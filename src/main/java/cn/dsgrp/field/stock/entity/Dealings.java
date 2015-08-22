package cn.dsgrp.field.stock.entity;

/**
 * 交易明细
 *
 * Created by baiqw on 15/8/22.
 */
public class Dealings extends IdEntity{
    public static final String NATURE_BUY = "买盘";
    public static final String NATURE_SELL = "卖盘";
    /**
     * 成交日期
     */
    private String cDate;
    /**
     * 成交时间
     */
    private String cTime;

    /**
     * 交易时间
     */
    private Long datetimes;
    /**
     * 成交价
     */
    private Float price;
    /**
     * 涨跌幅度
     */
    private Float upAndDownMargin;

    /**
     * 价格变动
     */
    private Float readjustPrices;

    /**
     * 成交量
     */
    private Long volumeOfBusiness;

    /**
     * 成交额
     */
    private Double turnover;

    /**
     * 性质
     * @serialField NATURE_BUY NATURE_SELL
     */
    private String nature;


    public Long getDatetimes() {
        return datetimes;
    }

    public void setDatetimes(Long datetimes) {
        this.datetimes = datetimes;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getUpAndDownMargin() {
        return upAndDownMargin;
    }

    public void setUpAndDownMargin(Float upAndDownMargin) {
        this.upAndDownMargin = upAndDownMargin;
    }

    public Float getReadjustPrices() {
        return readjustPrices;
    }

    public void setReadjustPrices(Float readjustPrices) {
        this.readjustPrices = readjustPrices;
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

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "Dealings{" +
                "cDate='" + cDate + '\'' +
                ", cTime='" + cTime + '\'' +
                ", datetimes=" + datetimes +
                ", price=" + price +
                ", upAndDownMargin=" + upAndDownMargin +
                ", readjustPrices=" + readjustPrices +
                ", volumeOfBusiness=" + volumeOfBusiness +
                ", turnover=" + turnover +
                ", nature='" + nature + '\'' +
                '}';
    }
}
