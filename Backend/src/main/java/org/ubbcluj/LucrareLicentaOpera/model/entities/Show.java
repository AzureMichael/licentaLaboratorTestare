package org.ubbcluj.LucrareLicentaOpera.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SHOWS")
public class Show implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ERA")
    private String era;

    @Column(name = "DIRECTOR")
    private String directing;

    @Column(name = "SCENOGRAPH")
    private String scenography;

    @Column(name = "IS_PREMIERE")
    private boolean premmiere;

    @Column(name = "NUMBER_OF_REPETITIONS")
    private Integer numberOfRepetitions;

    @Column(name = "COST")
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
