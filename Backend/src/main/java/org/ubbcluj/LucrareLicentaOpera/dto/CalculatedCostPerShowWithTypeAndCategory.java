package org.ubbcluj.LucrareLicentaOpera.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculatedCostPerShowWithTypeAndCategory {

    String title;

    List<AverageCostPerShowByYearDTO> costs;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AverageCostPerShowByYearDTO> getCosts() {
        return costs;
    }

    public void setCosts(List<AverageCostPerShowByYearDTO> costs) {
        this.costs = costs;
    }
}
