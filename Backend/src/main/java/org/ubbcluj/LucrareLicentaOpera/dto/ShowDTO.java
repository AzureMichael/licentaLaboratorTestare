package org.ubbcluj.LucrareLicentaOpera.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ShowDTO implements Serializable {


    private Integer id;


    private String title;


    private String era;


    private String directing;


    private String scenography;


    private boolean premmiere;


    private Integer numberOfRepetitions;

    private long cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public String getDirecting() {
        return directing;
    }

    public void setDirecting(String directing) {
        this.directing = directing;
    }

    public String getScenography() {
        return scenography;
    }

    public void setScenography(String scenography) {
        this.scenography = scenography;
    }

    public boolean isPremmiere() {
        return premmiere;
    }

    public void setPremmiere(boolean premmiere) {
        this.premmiere = premmiere;
    }

    public Integer getNumberOfRepetitions() {
        return numberOfRepetitions;
    }

    public void setNumberOfRepetitions(Integer numberOfRepetitions) {
        this.numberOfRepetitions = numberOfRepetitions;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
