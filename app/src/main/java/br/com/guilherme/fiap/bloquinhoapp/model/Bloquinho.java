package br.com.guilherme.fiap.bloquinhoapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bloquinho {
    private String id;
    private String name;
    private String theftChance;
    private LocalDate day;
    private String style;
    private String facebookLink;
    private LocalTime horario;
    private String quality;
    private String match;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheftChance() {
        return theftChance;
    }

    public void setTheftChance(String theftChance) {
        this.theftChance = theftChance;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }
}
