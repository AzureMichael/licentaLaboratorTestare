package org.ubbcluj.LucrareLicentaOpera.dao;

import org.springframework.stereotype.Component;
import org.ubbcluj.LucrareLicentaOpera.converter.AverageCostPerShowByYearConverter;
import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;
import org.ubbcluj.LucrareLicentaOpera.model.entities.AverageCostPerShowByYear;
import org.ubbcluj.LucrareLicentaOpera.model.repositories.AverageYearlyCostPerShowByYearRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AverageCostPerShowByYearDaoImpl implements AverageCostPerShowByYearDao {

    private final AverageCostPerShowByYearConverter averageCostPerShowByYearConverter;
    private final AverageYearlyCostPerShowByYearRepository averageYearlyCostPerShowByYearRepository;

    public AverageCostPerShowByYearDaoImpl(
            AverageCostPerShowByYearConverter averageCostPerShowByYearConverter,
            AverageYearlyCostPerShowByYearRepository averageYearlyCostPerShowByYearRepository) {

        this.averageCostPerShowByYearConverter = averageCostPerShowByYearConverter;
        this.averageYearlyCostPerShowByYearRepository = averageYearlyCostPerShowByYearRepository;

    }

    @Override
    public List<AverageCostPerShowByYearDTO> saveAll(List<AverageCostPerShowByYearDTO> averageCostPerShowByYears) {
        List<AverageCostPerShowByYearDTO> averageCostPerShowByYearDTOS = new ArrayList<>();
        averageCostPerShowByYears.forEach(averageCostPerShowByYearDTO -> {
            averageCostPerShowByYearDTOS.add(this.averageCostPerShowByYearConverter
                    .convert(this.averageYearlyCostPerShowByYearRepository
                            .save(this.averageCostPerShowByYearConverter.convert(averageCostPerShowByYearDTO))));
        });
        return averageCostPerShowByYearDTOS;
    }

    @Override
    public List<AverageCostPerShowByYearDTO> findAll() {
        return this.averageCostPerShowByYearConverter.convertAllToDtos((List<AverageCostPerShowByYear>)
                this.averageYearlyCostPerShowByYearRepository.findAll());
    }
}
