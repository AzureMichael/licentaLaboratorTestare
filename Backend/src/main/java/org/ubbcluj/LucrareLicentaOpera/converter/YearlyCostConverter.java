package org.ubbcluj.LucrareLicentaOpera.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.ubbcluj.LucrareLicentaOpera.dto.YearlyCostDTO;
import org.ubbcluj.LucrareLicentaOpera.model.entities.YearlyCost;

import java.util.ArrayList;
import java.util.List;

@Component
public class YearlyCostConverter implements Converter<YearlyCost, YearlyCostDTO> {
    @Override
    public YearlyCostDTO convert(YearlyCost yearlyCost) {
        YearlyCostDTO yearlyCostDTO = new YearlyCostDTO();
        BeanUtils.copyProperties(yearlyCost, yearlyCostDTO);
        return yearlyCostDTO;
    }

    public YearlyCost convert(YearlyCostDTO yearlyCostDTO) {
        YearlyCost yearlyCost = new YearlyCost();
        BeanUtils.copyProperties(yearlyCostDTO, yearlyCost);
        return yearlyCost;
    }

    public List<YearlyCost> convertAllToEntities(List<YearlyCostDTO> yearlyCostDTOS) {
        List<YearlyCost> yearlyCosts = new ArrayList<>();
        yearlyCostDTOS.forEach(yearlyCostDTO -> {
            YearlyCost yearlyCost = new YearlyCost();
            BeanUtils.copyProperties(yearlyCostDTO, yearlyCost);
            yearlyCosts.add(yearlyCost);
        });
        return yearlyCosts;
    }

    public List<YearlyCostDTO> convertAllToDtos(List<YearlyCost> yearlyCosts) {
        List<YearlyCostDTO> yearlyCostDTOS = new ArrayList<>();
        yearlyCosts.forEach(yearlyCost -> {
            YearlyCostDTO yearlyCostDTO = new YearlyCostDTO();
            BeanUtils.copyProperties(yearlyCost, yearlyCostDTO);
            yearlyCostDTOS.add(yearlyCostDTO);
        });
        return yearlyCostDTOS;
    }
}
