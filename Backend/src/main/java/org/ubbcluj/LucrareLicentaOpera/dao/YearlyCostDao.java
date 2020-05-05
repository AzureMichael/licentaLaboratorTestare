package org.ubbcluj.LucrareLicentaOpera.dao;

import org.ubbcluj.LucrareLicentaOpera.dto.YearlyCostDTO;

import java.util.List;

public interface YearlyCostDao {

    List<YearlyCostDTO> saveAll(List<YearlyCostDTO> shows);

    List<YearlyCostDTO> findAll();

    List<YearlyCostDTO> findByYear(Integer year);
}
