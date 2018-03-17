package com.zking.lq.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class LostLQ implements Serializable{
    private Long lstId;

    private String lstCustNo;

    private String lstCustName;

    private Long lstCustManagerId;

    private String lstCustManagerName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lstLastOrderDate;
    private String time1;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lstLostDate;
    private String time2;

    private String lstDelay;

    private String lstReason;

    private String lstStatus;

    private String status;

    private String zhuijia;

    public LostLQ(Long lstId, String lstCustNo, String lstCustName, Long lstCustManagerId, String lstCustManagerName, Date lstLastOrderDate, String time1, Date lstLostDate, String time2, String lstDelay, String lstReason, String lstStatus, String status, String zhuijia) {
        this.lstId = lstId;
        this.lstCustNo = lstCustNo;
        this.lstCustName = lstCustName;
        this.lstCustManagerId = lstCustManagerId;
        this.lstCustManagerName = lstCustManagerName;
        this.lstLastOrderDate = lstLastOrderDate;
        this.time1 = time1;
        this.lstLostDate = lstLostDate;
        this.time2 = time2;
        this.lstDelay = lstDelay;
        this.lstReason = lstReason;
        this.lstStatus = lstStatus;
        this.status = status;
        this.zhuijia = zhuijia;
    }

    public String getZhuijia() {
        return zhuijia;
    }

    public void setZhuijia(String zhuijia) {
        this.zhuijia = zhuijia;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LostLQ() {
        super();
    }

    public Long getLstId() {
        return lstId;
    }

    public void setLstId(Long lstId) {
        this.lstId = lstId;
    }

    public String getLstCustNo() {
        return lstCustNo;
    }

    public void setLstCustNo(String lstCustNo) {
        this.lstCustNo = lstCustNo;
    }

    public String getLstCustName() {
        return lstCustName;
    }

    public void setLstCustName(String lstCustName) {
        this.lstCustName = lstCustName;
    }

    public Long getLstCustManagerId() {
        return lstCustManagerId;
    }

    public void setLstCustManagerId(Long lstCustManagerId) {
        this.lstCustManagerId = lstCustManagerId;
    }

    public String getLstCustManagerName() {
        return lstCustManagerName;
    }

    public void setLstCustManagerName(String lstCustManagerName) {
        this.lstCustManagerName = lstCustManagerName;
    }

    public Date getLstLastOrderDate() {
        return lstLastOrderDate;
    }

    public void setLstLastOrderDate(Date lstLastOrderDate) {
        this.lstLastOrderDate = lstLastOrderDate;
    }

    public Date getLstLostDate() {
        return lstLostDate;
    }

    public void setLstLostDate(Date lstLostDate) {
        this.lstLostDate = lstLostDate;
    }

    public String getLstDelay() {
        return lstDelay;
    }

    public void setLstDelay(String lstDelay) {
        this.lstDelay = lstDelay;
    }

    public String getLstReason() {
        return lstReason;
    }

    public void setLstReason(String lstReason) {
        this.lstReason = lstReason;
    }

    public String getLstStatus() {
        return lstStatus;
    }

    public void setLstStatus(String lstStatus) {
        this.lstStatus = lstStatus;
    }

    @Override
    public String toString() {
        return "LostLQ{" +
                "lstId=" + lstId +
                ", lstCustNo='" + lstCustNo + '\'' +
                ", lstCustName='" + lstCustName + '\'' +
                ", lstCustManagerId=" + lstCustManagerId +
                ", lstCustManagerName='" + lstCustManagerName + '\'' +
                ", lstLastOrderDate=" + lstLastOrderDate +
                ", lstLostDate=" + lstLostDate +
                ", lstDelay='" + lstDelay + '\'' +
                ", lstReason='" + lstReason + '\'' +
                ", lstStatus='" + lstStatus + '\'' +
                '}';
    }
}