package cn.dsgrp.field.stock.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 股票
 *
 * Created by baiqw on 15/8/22.
 */
@Document
public class Stock extends AbstractDocument{
    /**
     * 股票简称名称
     */
    private String simpleName;
    /**
     * 股票代码
     */
    private long code;

    /**
     * 公司信息
     */
    private ListedCompany listedCompany;

    /**
     * 市场信息
     */
    private Market market;

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public ListedCompany getListedCompany() {
        return listedCompany;
    }

    public void setListedCompany(ListedCompany listedCompany) {
        this.listedCompany = listedCompany;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }


}
