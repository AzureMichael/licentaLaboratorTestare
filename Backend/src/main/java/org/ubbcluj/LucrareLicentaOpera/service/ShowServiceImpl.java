package org.ubbcluj.LucrareLicentaOpera.service;

import org.springframework.stereotype.Service;
import org.ubbcluj.LucrareLicentaOpera.dao.ShowDao;
import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowDao showDao;

    public ShowServiceImpl(ShowDao showDao) {
        this.showDao = showDao;
    }

    @Override
    public List<ShowDTO> saveAll(List<ShowDTO> shows) {
        return this.showDao.saveAll(shows);
    }

    @Override
    public List<ShowDTO> findAll() {
        return this.showDao.findAll();
    }
}
