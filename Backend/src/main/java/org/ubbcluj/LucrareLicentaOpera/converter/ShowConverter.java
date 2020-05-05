package org.ubbcluj.LucrareLicentaOpera.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;
import org.ubbcluj.LucrareLicentaOpera.model.entities.Show;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowConverter implements Converter<Show, ShowDTO> {
    @Override
    public ShowDTO convert(Show show) {
        ShowDTO showDTO = new ShowDTO();
        BeanUtils.copyProperties(show, showDTO);
        return showDTO;
    }

    public Show convert(ShowDTO showDTO) {
        Show show = new Show();
        BeanUtils.copyProperties(showDTO, show);
        return show;
    }

    public List<Show> convertAllToEntities(List<ShowDTO> showDTOs) {
        List<Show> shows = new ArrayList<>();
        showDTOs.forEach(showDTO -> {
            Show show = new Show();
            BeanUtils.copyProperties(showDTO, show);
            shows.add(show);
        });
        return shows;
    }

    public List<ShowDTO> convertAllToDtos(List<Show> shows) {
        List<ShowDTO> showDTOs = new ArrayList<>();
        shows.forEach(show -> {
            ShowDTO showDTO = new ShowDTO();
            BeanUtils.copyProperties(show, showDTO);
            showDTOs.add(showDTO);
        });
        return showDTOs;
    }
}
