package org.ubbcluj.LucrareLicentaOpera.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "YEARLY_COSTS")
public class YearlyCost {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "COST")
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
