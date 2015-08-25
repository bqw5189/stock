package cn.dsgrp.field.stock.entity;

/**
 * 上市公司信息
 *
 * Created by baiqw on 15/8/22.
 */
public class ListedCompany  extends AbstractDocument{
    /**
     * 公司简名
     */
    private String simpleName;
    /**
     * 公司全名
     */
    private String fullName;
    /**
     * 公司代码
     */
    private long code;

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }
}
