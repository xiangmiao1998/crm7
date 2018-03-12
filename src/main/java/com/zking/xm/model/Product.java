package com.zking.xm.model;

import java.io.Serializable;

public class Product implements Serializable{
    private Long prodId;

    private String prodName;

    private String prodType;

    private String prodBatch;

    private String prodUnit;

    private Float prodPrice;

    private String prodMemo;

    public Product(Long prodId, String prodName, String prodType, String prodBatch, String prodUnit, Float prodPrice, String prodMemo) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodType = prodType;
        this.prodBatch = prodBatch;
        this.prodUnit = prodUnit;
        this.prodPrice = prodPrice;
        this.prodMemo = prodMemo;
    }

    public Product() {
        super();
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdBatch() {
        return prodBatch;
    }

    public void setProdBatch(String prodBatch) {
        this.prodBatch = prodBatch;
    }

    public String getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(String prodUnit) {
        this.prodUnit = prodUnit;
    }

    public Float getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Float prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdMemo() {
        return prodMemo;
    }

    public void setProdMemo(String prodMemo) {
        this.prodMemo = prodMemo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", prodType='" + prodType + '\'' +
                ", prodBatch='" + prodBatch + '\'' +
                ", prodUnit='" + prodUnit + '\'' +
                ", prodPrice=" + prodPrice +
                ", prodMemo='" + prodMemo + '\'' +
                '}';
    }
}