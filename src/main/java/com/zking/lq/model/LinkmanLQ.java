package com.zking.lq.model;

import java.io.Serializable;

public class LinkmanLQ implements Serializable{
    private Long lkmId;

    private String lkmCustNo;

    private String lkmCustName;

    private String lkmName;

    private String lkmSex;

    private String lkmPostion;

    private String lkmTel;

    private String lkmMobile;

    private String lkmMemo;

    public LinkmanLQ(Long lkmId, String lkmCustNo, String lkmCustName, String lkmName, String lkmSex, String lkmPostion, String lkmTel, String lkmMobile, String lkmMemo) {
        this.lkmId = lkmId;
        this.lkmCustNo = lkmCustNo;
        this.lkmCustName = lkmCustName;
        this.lkmName = lkmName;
        this.lkmSex = lkmSex;
        this.lkmPostion = lkmPostion;
        this.lkmTel = lkmTel;
        this.lkmMobile = lkmMobile;
        this.lkmMemo = lkmMemo;
    }

    public LinkmanLQ() {
        super();
    }

    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmCustNo() {
        return lkmCustNo;
    }

    public void setLkmCustNo(String lkmCustNo) {
        this.lkmCustNo = lkmCustNo;
    }

    public String getLkmCustName() {
        return lkmCustName;
    }

    public void setLkmCustName(String lkmCustName) {
        this.lkmCustName = lkmCustName;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmSex() {
        return lkmSex;
    }

    public void setLkmSex(String lkmSex) {
        this.lkmSex = lkmSex;
    }

    public String getLkmPostion() {
        return lkmPostion;
    }

    public void setLkmPostion(String lkmPostion) {
        this.lkmPostion = lkmPostion;
    }

    public String getLkmTel() {
        return lkmTel;
    }

    public void setLkmTel(String lkmTel) {
        this.lkmTel = lkmTel;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    @Override
    public String toString() {
        return "LinkmanLQ{" +
                "lkmId=" + lkmId +
                ", lkmCustNo='" + lkmCustNo + '\'' +
                ", lkmCustName='" + lkmCustName + '\'' +
                ", lkmName='" + lkmName + '\'' +
                ", lkmSex='" + lkmSex + '\'' +
                ", lkmPostion='" + lkmPostion + '\'' +
                ", lkmTel='" + lkmTel + '\'' +
                ", lkmMobile='" + lkmMobile + '\'' +
                ", lkmMemo='" + lkmMemo + '\'' +
                '}';
    }
}