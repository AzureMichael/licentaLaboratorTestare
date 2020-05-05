package org.ubbcluj.LucrareLicentaOpera.service;

import org.springframework.stereotype.Service;
import org.ubbcluj.LucrareLicentaOpera.dao.AverageCostPerShowByYearDao;
import org.ubbcluj.LucrareLicentaOpera.dao.ShowDao;
import org.ubbcluj.LucrareLicentaOpera.dao.YearlyCostDao;
import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;
import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;
import org.ubbcluj.LucrareLicentaOpera.dto.YearlyCostDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CalculateCostsServiceImpl implements CalculateCostsService {

    private final ShowDao showDao;
    private final YearlyCostDao yearlyCostDao;
    private final AverageCostPerShowByYearDao averageCostPerShowByYearDao;

    public CalculateCostsServiceImpl(ShowDao showDao, YearlyCostDao yearlyCostDao, AverageCostPerShowByYearDao averageCostPerShowByYearDao) {
        this.showDao = showDao;
        this.yearlyCostDao = yearlyCostDao;
        this.averageCostPerShowByYearDao = averageCostPerShowByYearDao;
    }

    @Override
    public List<AverageCostPerShowByYearDTO> calculateAverageCostsForGivenYear(Integer year) {
        List<AverageCostPerShowByYearDTO> averageCostPerShowByYearDTOS = new ArrayList<>();
        List<ShowDTO> showDTOS = showDao.findAll();
        List<YearlyCostDTO> yearlyCostDTOS = yearlyCostDao.findByYear(year);
        AtomicLong cost = new AtomicLong();
        yearlyCostDTOS.forEach(yearlyCostDTO -> {
            AverageCostPerShowByYearDTO averageCostPerShowByYear = new AverageCostPerShowByYearDTO();
            averageCostPerShowByYear.setCategory(yearlyCostDTO.getCategory());
            averageCostPerShowByYear.setType(yearlyCostDTO.getType());
            averageCostPerShowByYear.setCost(yearlyCostDTO.getCost() / 60);
            cost.addAndGet(yearlyCostDTO.getCost() / 60);
            averageCostPerShowByYearDTOS.add(averageCostPerShowByYear);
        });
        showDTOS.forEach(showDTO -> {
            showDTO.setCost(cost.get() * showDTO.getNumberOfRepetitions());
        });
        this.showDao.saveAll(showDTOS);

        return this.averageCostPerShowByYearDao.saveAll(averageCostPerShowByYearDTOS);
    }
}
