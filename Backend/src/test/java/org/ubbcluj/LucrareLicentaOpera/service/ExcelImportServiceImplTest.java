package org.ubbcluj.LucrareLicentaOpera.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.ubbcluj.LucrareLicentaOpera.dao.AverageCostPerShowByYearDao;
import org.ubbcluj.LucrareLicentaOpera.dao.ShowDao;
import org.ubbcluj.LucrareLicentaOpera.dao.YearlyCostDao;
import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;
import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;
import org.ubbcluj.LucrareLicentaOpera.dto.YearlyCostDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ExcelImportServiceImplTest {
    @InjectMocks
    private ExcelImportServiceImpl importService;


    @Mock
    private ShowDao showDao;



    @Test
    public void readShowsFromExcelFile() {
        List<ShowDTO> showDTOList;

        ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(ShowDTO.class);

        try {
            this.importService.setTestInputFile("./src/test/java/org/ubbcluj/LucrareLicentaOpera/resources/Evenimente.xlsx");
            this.importService.readShowsFromExcelFile();
            Mockito.verify(this.showDao).saveAll((List<ShowDTO>) argumentCaptor.capture());
            showDTOList = (List<ShowDTO>) argumentCaptor.getValue();

            Assert.assertEquals("Academia Națională de Muzică \"Gheorghe Dima ", showDTOList.get(0).getTitle());
            Assert.assertEquals("Aida -", showDTOList.get(1).getTitle());
            Assert.assertEquals("Trubadurul -", showDTOList.get(30).getTitle());
            Assert.assertEquals(Integer.valueOf(2), showDTOList.get(30).getNumberOfRepetitions());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
