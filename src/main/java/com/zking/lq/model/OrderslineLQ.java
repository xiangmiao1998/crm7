package com.zking.lq.model;

import java.io.Serializable;

public class OrderslineLQ implements Serializable{
    private Long oddId;

    private Long oddOrderId;

    private Long oddProdId;

    private String prodName;

    private Long oddCount;

    private String oddUnit;

    private Float oddPrice;

    private Float money;

    public OrderslineLQ(Long oddId, Long oddOrderId, Long oddProdId, String prodName, Long oddCount, String oddUnit, Float oddPrice, Float money) {
        this.oddId = oddId;
        this.oddOrderId = oddOrderId;
        this.oddProdId = oddProdId;
        this.prodName = prodName;
        this.oddCount = oddCount;
        this.oddUnit = oddUnit;
        this.oddPrice = oddPrice;
        this.money = money;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public OrderslineLQ() {
        super();
    }

    public Long getOddId() {
        return oddId;
    }

    public void setOddId(Long oddId) {
        this.oddId = oddId;
    }

    public Long getOddOrderId() {
        return oddOrderId;
    }

    public void setOddOrderId(Long oddOrderId) {
        this.oddOrderId = oddOrderId;
    }

    public Long getOddProdId() {
        return oddProdId;
    }

    public void setOddProdId(Long oddProdId) {
        this.oddProdId = oddProdId;
    }

    public Long getOddCount() {
        return oddCount;
    }

    public void setOddCount(Long oddCount) {
        this.oddCount = oddCount;
    }

    public String getOddUnit() {
        return oddUnit;
    }

    public void setOddUnit(String oddUnit) {
        this.oddUnit = oddUnit;
    }

    public Float getOddPrice() {
        return oddPrice;
    }

    public void setOddPrice(Float oddPrice) {
        this.oddPrice = oddPrice;
    }

    @Override
    public String toString() {
        return "OrderslineLQ{" +
                "oddId=" + oddId +
                ", oddOrderId=" + oddOrderId +
                ", oddProdId=" + oddProdId +
                ", oddCount=" + oddCount +
                ", oddUnit='" + oddUnit + '\'' +
                ", oddPrice=" + oddPrice +
                '}';
    }
}