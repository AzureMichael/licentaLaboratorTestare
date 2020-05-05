package org.ubbcluj.LucrareLicentaOpera.dao;

import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;

import java.util.List;

public interface AverageCostPerShowByYearDao {

    List<AverageCostPerShowByYearDTO> saveAll(List<AverageCostPerShowByYearDTO> averageCostPerShowByYearDTOS);

    List<AverageCostPerShowByYearDTO> findAll();

}
