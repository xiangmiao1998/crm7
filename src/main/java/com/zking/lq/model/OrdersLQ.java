package com.zking.lq.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class OrdersLQ implements Serializable{
    private Long odrId;

    private String odrCustomer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date odrDate;

    private String odrAddr;

    private String odrStatus;

    private Float money;

    private String time;

    private String status;

    public OrdersLQ(Long odrId, String odrCustomer, Date odrDate, String odrAddr, String odrStatus, Float money, String time, String status) {
        this.odrId = odrId;
        this.odrCustomer = odrCustomer;
        this.odrDate = odrDate;
        this.odrAddr = odrAddr;
        this.odrStatus = odrStatus;
        this.money = money;
        this.time = time;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public OrdersLQ() {
        super();
    }

    public Long getOdrId() {
        return odrId;
    }

    public void setOdrId(Long odrId) {
        this.odrId = odrId;
    }

    public String getOdrCustomer() {
        return odrCustomer;
    }

    public void setOdrCustomer(String odrCustomer) {
        this.odrCustomer = odrCustomer;
    }

    public Date getOdrDate() {
        return odrDate;
    }

    public void setOdrDate(Date odrDate) {
        this.odrDate = odrDate;
    }

    public String getOdrAddr() {
        return odrAddr;
    }

    public void setOdrAddr(String odrAddr) {
        this.odrAddr = odrAddr;
    }

    public String getOdrStatus() {
        return odrStatus;
    }

    public void setOdrStatus(String odrStatus) {
        this.odrStatus = odrStatus;
    }

    @Override
    public String toString() {
        return "OrdersLQ{" +
                "odrId=" + odrId +
                ", odrCustomer='" + odrCustomer + '\'' +
                ", odrDate=" + odrDate +
                ", odrAddr='" + odrAddr + '\'' +
                ", odrStatus='" + odrStatus + '\'' +
                '}';
    }
}