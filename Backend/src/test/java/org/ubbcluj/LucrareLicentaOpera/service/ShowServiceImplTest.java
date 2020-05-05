package org.ubbcluj.LucrareLicentaOpera.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.ubbcluj.LucrareLicentaOpera.dao.ShowDao;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ShowServiceImplTest {

    @InjectMocks
    private ShowServiceImpl showService;

    @Mock
    private ShowDao showDao;

    @Test
    public void findAll() {

        this.showService.findAll();

        Mockito.verify(showDao).findAll();
    }
}
