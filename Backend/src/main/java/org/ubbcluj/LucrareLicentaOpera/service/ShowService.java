package org.ubbcluj.LucrareLicentaOpera.service;

import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;

import java.util.List;

public interface ShowService {

    List<ShowDTO> saveAll(List<ShowDTO> shows);

    List<ShowDTO> findAll();

}
