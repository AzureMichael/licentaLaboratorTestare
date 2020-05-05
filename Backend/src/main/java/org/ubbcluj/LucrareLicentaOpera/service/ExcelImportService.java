package org.ubbcluj.LucrareLicentaOpera.service;

import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;

import java.io.IOException;
import java.util.List;

public interface ExcelImportService {
    void setInputFile(String inputFile);
    List<ShowDTO> readShowsFromExcelFile() throws IOException;

    void setTestInputFile(String inputFile);
}
