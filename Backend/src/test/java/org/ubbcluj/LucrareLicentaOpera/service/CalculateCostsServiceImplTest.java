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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CalculateCostsServiceImplTest {

    @InjectMocks
    private ExcelImportServiceImpl importService;

    @InjectMocks
    private CalculateCostsServiceImpl calculateCostsService;

    @Mock
    private ShowDao showDao;


    @Mock
    private YearlyCostDao yearlyCostDao;

    @Mock
    private AverageCostPerShowByYearDao averageCostPerShowByYearDao;
    @Test
    public void calculateAverageCostsForGivenYear() {
        List<ShowDTO> showDTOList;

        ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(AverageCostPerShowByYearDTO.class);


        try {
            this.importService.setTestInputFile("./src/test/java/org/ubbcluj/LucrareLicentaOpera/resources/Evenimente.xlsx");
            this.importService.readShowsFromExcelFile();
            Mockito.verify(this.showDao).saveAll((List<ShowDTO>) argumentCaptor.capture());
            showDTOList = (List<ShowDTO>) argumentCaptor.getValue();

            Mockito.when(this.showDao.findAll()).thenReturn(showDTOList);
            Mockito.when(this.yearlyCostDao.findByYear(2019)).thenReturn(createYearlyCosts());


            this.calculateCostsService.calculateAverageCostsForGivenYear(2019);

            Mockito.verify(this.averageCostPerShowByYearDao)
                    .saveAll((List<AverageCostPerShowByYearDTO>) argumentCaptor.capture());

            List<AverageCostPerShowByYearDTO> averageCostPerShowByYearDTOS =
                    (List<AverageCostPerShowByYearDTO>) argumentCaptor.getValue();

            Assert.assertEquals("TEST1", averageCostPerShowByYearDTOS.get(0).getCategory());
            Assert.assertEquals(1000 / 60, averageCostPerShowByYearDTOS.get(0).getCost());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<YearlyCostDTO> createYearlyCosts() {
        List<YearlyCostDTO> yearlyCostDTOS = new ArrayList<>();

        YearlyCostDTO yearlyCostDTO = new YearlyCostDTO();
        yearlyCostDTO.setCategory("TEST1");
        yearlyCostDTO.setYear(2019);
        yearlyCostDTO.setCost(1000);

        YearlyCostDTO yearlyCostDTO2 = new YearlyCostDTO();
        yearlyCostDTO2.setCategory("TEST1");
        yearlyCostDTO2.setYear(2019);
        yearlyCostDTO2.setCost(2000);

        YearlyCostDTO yearlyCostDTO3 = new YearlyCostDTO();
        yearlyCostDTO3.setCategory("TEST1");
        yearlyCostDTO3.setYear(2019);
        yearlyCostDTO3.setCost(3000);

        yearlyCostDTOS.add(yearlyCostDTO);
        yearlyCostDTOS.add(yearlyCostDTO2);
        yearlyCostDTOS.add(yearlyCostDTO3);

        return yearlyCostDTOS;
    }

}
