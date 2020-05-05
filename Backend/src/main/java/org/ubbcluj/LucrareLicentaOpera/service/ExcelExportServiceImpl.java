package org.ubbcluj.LucrareLicentaOpera.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.ubbcluj.LucrareLicentaOpera.dao.AverageCostPerShowByYearDao;
import org.ubbcluj.LucrareLicentaOpera.dao.ShowDao;
import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;
import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExcelExportServiceImpl implements ExcelExportService {

    private final ShowDao showDao;
    private final AverageCostPerShowByYearDao showByYearDao;

    private String outputFile = "";

    public ExcelExportServiceImpl(ShowDao showDao, AverageCostPerShowByYearDao showByYearDao) {
        this.showDao = showDao;
        this.showByYearDao = showByYearDao;
    }

    @Override
    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile + ".xlsx";
    }

    @Override
    public void write() throws IOException {

    }

    @Override
    public void writeAverageCostWithShows(Integer year) throws IOException {
        List<ShowDTO> showDTOList = showDao.findAll();
        List<AverageCostPerShowByYearDTO> averageCostPerShowByYearDTOS = this.showByYearDao.findAll();
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");

        //This data needs to be written (Object[])

        //Iterate over data and write to sheet

        AtomicInteger rownum = new AtomicInteger(1);
        AtomicInteger cellnum = new AtomicInteger(0);
        Row rowHeader = sheet.createRow(0);

        Cell firstCellHeader = rowHeader.createCell(cellnum.get());
        firstCellHeader.setCellValue("Titlu Spectacol");
        cellnum.getAndIncrement();
        averageCostPerShowByYearDTOS.forEach(averageCostPerShowByYearDTO -> {
            Cell headerCell = rowHeader.createCell(cellnum.get());
            headerCell.setCellValue(averageCostPerShowByYearDTO.getCategory());
            cellnum.getAndIncrement();
        });
        Cell lastCellHeader = rowHeader.createCell(cellnum.get());
        lastCellHeader.setCellValue("TOTAL");
        cellnum.set(0);

        showDTOList.forEach(showDTO -> {
            Row row = sheet.createRow(rownum.get());
            Cell firstCell = row.createCell(cellnum.get());
            firstCell.setCellValue(showDTO.getTitle());
            cellnum.getAndIncrement();
            averageCostPerShowByYearDTOS.forEach(averageCostPerShowByYearDTO -> {
                Cell costCell = row.createCell(cellnum.get());
                costCell.setCellValue(averageCostPerShowByYearDTO.getCost()*showDTO.getNumberOfRepetitions());
                cellnum.getAndIncrement();
            });
            Cell lastCell = row.createCell(cellnum.get());
            lastCell.setCellValue(showDTO.getCost());
            rownum.getAndIncrement();
            cellnum.set(0);
        });

        try
    {
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File(outputFile));
        workbook.write(out);
        out.close();
    }
        catch (Exception e)
    {
        e.printStackTrace();
    }
    }
}
