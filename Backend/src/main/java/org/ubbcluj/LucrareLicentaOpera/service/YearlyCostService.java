package org.ubbcluj.LucrareLicentaOpera.service;

import org.ubbcluj.LucrareLicentaOpera.dto.YearlyCostDTO;

import java.util.List;

public interface YearlyCostService {

    List<YearlyCostDTO> saveAll(List<YearlyCostDTO> yearlyCostDTOS);

    List<YearlyCostDTO> findAll();


}
