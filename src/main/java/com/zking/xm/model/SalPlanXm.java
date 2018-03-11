package com.zking.xm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class SalPlanXm implements Serializable{
    private Long plaId;

    private Long plaChcId;

    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date plaDate;

    private String plaTodo;

    private String plaResult;

    public SalPlanXm(Long plaId, Long plaChcId, Date plaDate, String plaTodo, String plaResult) {
        this.plaId = plaId;
        this.plaChcId = plaChcId;
        this.plaDate = plaDate;
        this.plaTodo = plaTodo;
        this.plaResult = plaResult;
    }

    public SalPlanXm() {
        super();
    }

    public Long getPlaId() {
        return plaId;
    }

    public void setPlaId(Long plaId) {
        this.plaId = plaId;
    }

    public Long getPlaChcId() {
        return plaChcId;
    }

    public void setPlaChcId(Long plaChcId) {
        this.plaChcId = plaChcId;
    }

    public Date getPlaDate() {
        return plaDate;
    }

    public void setPlaDate(Date plaDate) {
        this.plaDate = plaDate;
    }

    public String getPlaTodo() {
        return plaTodo;
    }

    public void setPlaTodo(String plaTodo) {
        this.plaTodo = plaTodo;
    }

    public String getPlaResult() {
        return plaResult;
    }

    public void setPlaResult(String plaResult) {
        this.plaResult = plaResult;
    }

    @Override
    public String toString() {
        return "SalPlanXm{" +
                "plaId=" + plaId +
                ", plaChcId=" + plaChcId +
                ", plaDate=" + plaDate +
                ", plaTodo='" + plaTodo + '\'' +
                ", plaResult='" + plaResult + '\'' +
                '}';
    }
}