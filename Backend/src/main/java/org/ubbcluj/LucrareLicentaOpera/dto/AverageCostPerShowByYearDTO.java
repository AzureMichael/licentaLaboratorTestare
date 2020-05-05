package org.ubbcluj.LucrareLicentaOpera.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class AverageCostPerShowByYearDTO implements Serializable {


    private Integer id;


    private String name;


    private String category;


    private String type;


    private long cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
