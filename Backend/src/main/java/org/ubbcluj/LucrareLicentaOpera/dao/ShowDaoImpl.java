package org.ubbcluj.LucrareLicentaOpera.dao;

import org.springframework.stereotype.Component;
import org.ubbcluj.LucrareLicentaOpera.converter.ShowConverter;
import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;
import org.ubbcluj.LucrareLicentaOpera.model.entities.Show;
import org.ubbcluj.LucrareLicentaOpera.model.repositories.ShowRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowDaoImpl implements ShowDao {
    private final ShowRepository showRepository;
    private final ShowConverter showConverter;

    public ShowDaoImpl(ShowRepository showRepository, ShowConverter showConverter) {
        this.showRepository = showRepository;
        this.showConverter = showConverter;
    }

    @Override
    public List<ShowDTO> saveAll(List<ShowDTO> shows) {
        List<ShowDTO> showDTOs = new ArrayList<>();
        shows.forEach(showDTO -> {
            showDTOs.add(this.showConverter.convert(this.showRepository.save(this.showConverter.convert(showDTO))));
        });
        return showDTOs;
    }

    @Override
    public List<ShowDTO> findAll() {
        return this.showConverter.convertAllToDtos((List<Show>) this.showRepository.findAll());
    }
}
