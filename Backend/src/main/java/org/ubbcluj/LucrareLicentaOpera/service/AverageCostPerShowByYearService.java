package org.ubbcluj.LucrareLicentaOpera.service;

import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;

import java.util.List;

public interface AverageCostPerShowByYearService {

    List<AverageCostPerShowByYearDTO> saveAll(List<AverageCostPerShowByYearDTO> averageCostPerShowByYearDTOS);

    List<AverageCostPerShowByYearDTO> findAll();

}
