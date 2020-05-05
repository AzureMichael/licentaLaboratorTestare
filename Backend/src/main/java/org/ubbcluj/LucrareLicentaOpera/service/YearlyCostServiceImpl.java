package org.ubbcluj.LucrareLicentaOpera.service;

import org.springframework.stereotype.Component;
import org.ubbcluj.LucrareLicentaOpera.dao.YearlyCostDao;
import org.ubbcluj.LucrareLicentaOpera.dto.YearlyCostDTO;

import java.util.List;

@Component
public class YearlyCostServiceImpl implements YearlyCostService {

    private final YearlyCostDao yearlyCostDao;

    public YearlyCostServiceImpl(YearlyCostDao yearlyCostDao) {
        this.yearlyCostDao = yearlyCostDao;
    }

    @Override
    public List<YearlyCostDTO> saveAll(List<YearlyCostDTO> yearlyCostDTOS) {
        return yearlyCostDao.saveAll(yearlyCostDTOS);
    }

    @Override
    public List<YearlyCostDTO> findAll() {
        return this.yearlyCostDao.findAll();
    }
}
