package org.ubbcluj.LucrareLicentaOpera.service;

import org.springframework.stereotype.Service;
import org.ubbcluj.LucrareLicentaOpera.dao.AverageCostPerShowByYearDao;
import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;

import java.util.List;

@Service
public class AverageCostPerShowByYearServiceImpl implements AverageCostPerShowByYearService {

    private final AverageCostPerShowByYearDao averageCostPerShowByYearDao;

    public AverageCostPerShowByYearServiceImpl(AverageCostPerShowByYearDao averageCostPerShowByYearDao) {
        this.averageCostPerShowByYearDao = averageCostPerShowByYearDao;
    }

    @Override
    public List<AverageCostPerShowByYearDTO> saveAll(List<AverageCostPerShowByYearDTO> averageCostPerShowByYearDTOS) {
        return this.averageCostPerShowByYearDao.saveAll(averageCostPerShowByYearDTOS);
    }

    @Override
    public List<AverageCostPerShowByYearDTO> findAll() {
        return this.averageCostPerShowByYearDao.findAll();
    }
}
