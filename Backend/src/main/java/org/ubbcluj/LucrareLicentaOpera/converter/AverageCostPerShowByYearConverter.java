package org.ubbcluj.LucrareLicentaOpera.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;
import org.ubbcluj.LucrareLicentaOpera.model.entities.AverageCostPerShowByYear;

import java.util.ArrayList;
import java.util.List;

@Component
public class AverageCostPerShowByYearConverter implements Converter<AverageCostPerShowByYear, AverageCostPerShowByYearDTO> {
    @Override
    public AverageCostPerShowByYearDTO convert(AverageCostPerShowByYear averageCostPerShowByYear) {
        AverageCostPerShowByYearDTO averageCostPerShowByYearDTO = new AverageCostPerShowByYearDTO();
        BeanUtils.copyProperties(averageCostPerShowByYear, averageCostPerShowByYearDTO);
        return averageCostPerShowByYearDTO;
    }

    public AverageCostPerShowByYear convert(AverageCostPerShowByYearDTO averageCostPerShowByYearDTO) {
        AverageCostPerShowByYear averageCostPerShowByYear = new AverageCostPerShowByYear();
        BeanUtils.copyProperties(averageCostPerShowByYearDTO, averageCostPerShowByYear);
        return averageCostPerShowByYear;
    }

    public List<AverageCostPerShowByYear> convertAllToEntities(List<AverageCostPerShowByYearDTO> averageCostPerShowByYearDTOS) {
        List<AverageCostPerShowByYear> averageCostPerShowByYears = new ArrayList<>();
        averageCostPerShowByYearDTOS.forEach(yearlyCostDTO -> {
            AverageCostPerShowByYear averageCostPerShowByYear = new AverageCostPerShowByYear();
            BeanUtils.copyProperties(yearlyCostDTO, averageCostPerShowByYear);
            averageCostPerShowByYears.add(averageCostPerShowByYear);
        });
        return averageCostPerShowByYears;
    }

    public List<AverageCostPerShowByYearDTO> convertAllToDtos(List<AverageCostPerShowByYear> averageCostPerShowByYears) {
        List<AverageCostPerShowByYearDTO> averageCostPerShowByYearDTOS = new ArrayList<>();
        averageCostPerShowByYears.forEach(averageCostPerShowByYear -> {
            AverageCostPerShowByYearDTO yearlyCostDTO = new AverageCostPerShowByYearDTO();
            BeanUtils.copyProperties(averageCostPerShowByYear, yearlyCostDTO);
            averageCostPerShowByYearDTOS.add(yearlyCostDTO);
        });
        return averageCostPerShowByYearDTOS;
    }

}
