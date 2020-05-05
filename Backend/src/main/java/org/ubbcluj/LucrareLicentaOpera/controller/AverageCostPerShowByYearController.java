package org.ubbcluj.LucrareLicentaOpera.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.ubbcluj.LucrareLicentaOpera.dao.ShowDao;
import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;
import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;
import org.ubbcluj.LucrareLicentaOpera.service.AverageCostPerShowByYearService;
import org.ubbcluj.LucrareLicentaOpera.service.CalculateCostsService;
import org.ubbcluj.LucrareLicentaOpera.service.ExcelExportService;
import org.ubbcluj.LucrareLicentaOpera.service.ExcelImportService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "calculateCosts")
public class AverageCostPerShowByYearController {

    private final AverageCostPerShowByYearService averageCostPerShowByYearService;
    private final CalculateCostsService calculateCostsService;
    private final ExcelImportService excelImportService;
    private final ExcelExportService excelExportService;
    private final ShowDao showDao;

    public AverageCostPerShowByYearController(AverageCostPerShowByYearService averageCostPerShowByYearService, CalculateCostsService calculateCostsService, ExcelImportService excelImportService, ExcelExportService excelExportService, ShowDao showDao) {
        this.averageCostPerShowByYearService = averageCostPerShowByYearService;
        this.calculateCostsService = calculateCostsService;
        this.excelImportService = excelImportService;
        this.excelExportService = excelExportService;
        this.showDao = showDao;
    }

    @PostMapping(produces = "application/json")
    public List<AverageCostPerShowByYearDTO> saveYearlyCosts(@RequestBody List<AverageCostPerShowByYearDTO> yearlyCostDTOS){
        return this.averageCostPerShowByYearService.saveAll(yearlyCostDTOS);
    }

    @GetMapping(produces = "application/json")
    public List<AverageCostPerShowByYearDTO> findYearlyCosts(){
        return this.averageCostPerShowByYearService.findAll();
    }

    @GetMapping(path = "/import")
    public List<ShowDTO> importListsFromExcel(@RequestParam String filename){
        this.excelImportService.setInputFile(filename);
        try {
            this.excelImportService.readShowsFromExcelFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.showDao.findAll();
    }

    @PutMapping(path = "/calculate")
    public List<AverageCostPerShowByYearDTO> calculateShowAverageCostsforGivenYear(@RequestParam Integer year){
        return this.calculateCostsService.calculateAverageCostsForGivenYear(year);
    }

    @PostMapping(path = "/export")
    public HttpStatus exportCostsByShowForGivenYear(@RequestParam Integer year){
        excelExportService.setOutputFile("Export " + year);
        try {
            excelExportService.writeAverageCostWithShows(year);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return HttpStatus.OK;
    }

}
