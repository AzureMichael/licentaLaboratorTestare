package org.ubbcluj.LucrareLicentaOpera.service;

import org.ubbcluj.LucrareLicentaOpera.dto.AverageCostPerShowByYearDTO;
import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;

import java.io.IOException;
import java.util.List;

public interface ExcelExportService {
    void setOutputFile(String inputFile);
    void write() throws IOException;
    void writeAverageCostWithShows(Integer year) throws IOException;
}
