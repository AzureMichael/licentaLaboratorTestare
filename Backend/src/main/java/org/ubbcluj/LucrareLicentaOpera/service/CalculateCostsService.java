package org.ubbcluj.LucrareLicentaOpera.service;

import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;

import java.util.List;

public interface CalculateCostsService {

    List<AverageCostPerShowByYearDTO> calculateAverageCostsForGivenYear(Integer year);

}
