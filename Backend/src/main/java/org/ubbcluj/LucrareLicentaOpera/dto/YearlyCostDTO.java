package org.ubbcluj.LucrareLicentaOpera.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class YearlyCostDTO implements Serializable {
    private Integer id;

    private Integer year;

    private String category;

    private String type;

    private long cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
