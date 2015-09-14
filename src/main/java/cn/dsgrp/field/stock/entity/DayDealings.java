package cn.dsgrp.field.stock.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * 交易明细
 *
 * Created by baiqw on 15/8/22.
 */
@Document
public class DayDealings extends AbstractDocument {
    /**
     * 股票信息
     */
    private Stock stock;
    /**
     * 成交日期
     */
    private String cDate;

    /**
     * 开盘交价
     */
    private Float openPrice;

    /**
     * 最高价
     */
    private Float maxPrice;

    /**
     * 收盘价
     */
    private Float closePrice;

    /**
     * 最低 价
     */
    private Float minPrice;

    /**
     * 成交量
     */
    private Long volumeOfBusiness;

    /**
     * 成交额
     */
    private Double turnover;


    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public Float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Float openPrice) {
        this.openPrice = openPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Float getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Float closePrice) {
        this.closePrice = closePrice;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Long getVolumeOfBusiness() {
        return volumeOfBusiness;
    }

    public void setVolumeOfBusiness(Long volumeOfBusiness) {
        this.volumeOfBusiness = volumeOfBusiness;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    @Override
    public String toString() {
        return "DayDealings{" +
                "stock=" + stock +
                ", cDate='" + cDate + '\'' +
                ", openPrice=" + openPrice +
                ", maxPrice=" + maxPrice +
                ", closePrice=" + closePrice +
                ", minPrice=" + minPrice +
                ", volumeOfBusiness=" + volumeOfBusiness +
                ", turnover=" + turnover +
                '}';
    }
}
