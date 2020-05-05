package org.ubbcluj.LucrareLicentaOpera.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.ubbcluj.LucrareLicentaOpera.dao.ShowDao;
import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelImportServiceImpl implements ExcelImportService {
    private final ShowDao showDao;
    private String inputFileName = "./src/main/resources/excel/";

    public ExcelImportServiceImpl(ShowDao showDao) {
        this.showDao = showDao;
    }

    @Override
    public void setInputFile(String inputFile) {
        this.inputFileName += inputFile;
    }

    @Override
    public List<ShowDTO> readShowsFromExcelFile() throws IOException {
        List<ShowDTO> showDTOs = new ArrayList<>();
        File file = new File(this.inputFileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(1);
            Iterator<Row> itr = sheet.iterator();
            itr.next();
            itr.next();
            while(itr.hasNext()){
                Row row = itr.next();
                String showTitle = row.getCell(1).getStringCellValue();
                Double numberOfShowsString = row.getCell(2).getNumericCellValue();
                Integer numberOfShows = numberOfShowsString.intValue();
                ShowDTO showDTO = new ShowDTO();
                showDTO.setTitle(showTitle);
                showDTO.setNumberOfRepetitions(numberOfShows);
                showDTOs.add(showDTO);
            }
            showDTOs.remove(showDTOs.size()-1);
            return this.showDao.saveAll(showDTOs);

        }catch (FileNotFoundException f){
            throw f;
        }



    }
    @Override
    public void setTestInputFile(String inputFile) {
        this.inputFileName = inputFile;
    }
}
