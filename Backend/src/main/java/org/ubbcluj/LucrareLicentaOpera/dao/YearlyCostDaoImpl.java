package org.ubbcluj.LucrareLicentaOpera.dao;

import org.springframework.stereotype.Component;
import org.ubbcluj.LucrareLicentaOpera.converter.YearlyCostConverter;
import org.ubbcluj.LucrareLicentaOpera.dto.YearlyCostDTO;
import org.ubbcluj.LucrareLicentaOpera.model.entities.YearlyCost;
import org.ubbcluj.LucrareLicentaOpera.model.repositories.YearlyCostRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class YearlyCostDaoImpl implements YearlyCostDao {

    private final YearlyCostConverter yearlyCostConverter;
    private final YearlyCostRepository yearlyCostRepository;

    public YearlyCostDaoImpl(YearlyCostConverter yearlyCostConverter, YearlyCostRepository yearlyCostRepository) {
        this.yearlyCostConverter = yearlyCostConverter;
        this.yearlyCostRepository = yearlyCostRepository;
    }

    @Override
    public List<YearlyCostDTO> saveAll(List<YearlyCostDTO> yearlyCostDTOS) {
        List<YearlyCostDTO> yearlyCostDTOs = new ArrayList<>();
        yearlyCostDTOS.forEach(yearlyCostDTO -> {
            yearlyCostDTOs.add(this.yearlyCostConverter
                    .convert(this.yearlyCostRepository.save(this.yearlyCostConverter.convert(yearlyCostDTO))));
        });
        return yearlyCostDTOs;
    }

    @Override
    public List<YearlyCostDTO> findAll() {
        return this.yearlyCostConverter.convertAllToDtos((List<YearlyCost>) this.yearlyCostRepository.findAll());
    }

    @Override
    public List<YearlyCostDTO> findByYear(Integer year) {
        return this.yearlyCostConverter.convertAllToDtos(this.yearlyCostRepository.findByYear(year));
    }
}
