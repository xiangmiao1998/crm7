package com.zking.lq.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ActivityLQ implements Serializable{
    private Long atvId;

    private String atvCustNo;

    private String atvCustName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date atvDate;

    private String atvPlace;

    private String atvTitle;

    private String atvRemark;

    private String atvDesc;

    private String Date;

    public ActivityLQ(Long atvId, String atvCustNo, String atvCustName, Date atvDate, String atvPlace, String atvTitle, String atvRemark, String atvDesc) {
        this.atvId = atvId;
        this.atvCustNo = atvCustNo;
        this.atvCustName = atvCustName;
        this.atvDate = atvDate;
        this.atvPlace = atvPlace;
        this.atvTitle = atvTitle;
        this.atvRemark = atvRemark;
        this.atvDesc = atvDesc;
    }

    public ActivityLQ(Long atvId, String atvCustNo, String atvCustName, java.util.Date atvDate, String atvPlace, String atvTitle, String atvRemark, String atvDesc, String date) {
        this.atvId = atvId;
        this.atvCustNo = atvCustNo;
        this.atvCustName = atvCustName;
        this.atvDate = atvDate;
        this.atvPlace = atvPlace;
        this.atvTitle = atvTitle;
        this.atvRemark = atvRemark;
        this.atvDesc = atvDesc;
        Date = date;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public ActivityLQ() {
        super();
    }

    public Long getAtvId() {
        return atvId;
    }

    public void setAtvId(Long atvId) {
        this.atvId = atvId;
    }

    public String getAtvCustNo() {
        return atvCustNo;
    }

    public void setAtvCustNo(String atvCustNo) {
        this.atvCustNo = atvCustNo;
    }

    public String getAtvCustName() {
        return atvCustName;
    }

    public void setAtvCustName(String atvCustName) {
        this.atvCustName = atvCustName;
    }

    public Date getAtvDate() {
        return atvDate;
    }

    public void setAtvDate(Date atvDate) {
        this.atvDate = atvDate;
    }

    public String getAtvPlace() {
        return atvPlace;
    }

    public void setAtvPlace(String atvPlace) {
        this.atvPlace = atvPlace;
    }

    public String getAtvTitle() {
        return atvTitle;
    }

    public void setAtvTitle(String atvTitle) {
        this.atvTitle = atvTitle;
    }

    public String getAtvRemark() {
        return atvRemark;
    }

    public void setAtvRemark(String atvRemark) {
        this.atvRemark = atvRemark;
    }

    public String getAtvDesc() {
        return atvDesc;
    }

    public void setAtvDesc(String atvDesc) {
        this.atvDesc = atvDesc;
    }

    @Override
    public String toString() {
        return "ActivityLQ{" +
                "atvId=" + atvId +
                ", atvCustNo='" + atvCustNo + '\'' +
                ", atvCustName='" + atvCustName + '\'' +
                ", atvDate=" + atvDate +
                ", atvPlace='" + atvPlace + '\'' +
                ", atvTitle='" + atvTitle + '\'' +
                ", atvRemark='" + atvRemark + '\'' +
                ", atvDesc='" + atvDesc + '\'' +
                '}';
    }
}