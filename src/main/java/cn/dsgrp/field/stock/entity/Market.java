package cn.dsgrp.field.stock.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * 市场信息
 * Created by baiqw on 15/8/22.
 */
@Document
public class Market extends AbstractDocument{
    public static final Market SH_MARKET = new Market(6l, "沪市","sh");
    public static final Market SH_A_MARKET = new Market(61l, "A股","6",SH_MARKET);
    public static final Market SH_B_MARKET = new Market(62l, "B股","9",SH_MARKET);

    /**
     * 市场名称
     */
    private String name;
    /**
     * 市场标识
     */
    private String code;
    /**
     * 上级市场
     */
    private Market parentMarket;


    public Market(long id,String name, String code, Market parentMarket) {
        this.name = name;
        this.code = code;
        this.parentMarket = parentMarket;
        this.setId(BigInteger.valueOf(id));
    }



    public Market(long id, String name, String code) {
        this.name = name;
        this.code = code;
        this.setId(BigInteger.valueOf(id));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Market getParentMarket() {
        return parentMarket;
    }

    public void setParentMarket(Market parentMarket) {
        this.parentMarket = parentMarket;
    }
}
