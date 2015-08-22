package cn.dsgrp.field.stock.grab;

import cn.dsgrp.field.stock.entity.Stock;

import java.util.List;

/**
 * 股票列表
 *
 * Created by baiqw on 15/8/22.
 */
public interface IStockList {
    /**
     * 获取 市场 所有股票信息
     *
     * @return 股票列表信息
     */
    public List<Stock> list();
}
