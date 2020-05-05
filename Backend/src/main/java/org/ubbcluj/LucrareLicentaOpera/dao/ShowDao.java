package org.ubbcluj.LucrareLicentaOpera.dao;

import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;

import java.util.List;

public interface ShowDao {

    List<ShowDTO> saveAll(List<ShowDTO> shows);

    List<ShowDTO> findAll();
}
