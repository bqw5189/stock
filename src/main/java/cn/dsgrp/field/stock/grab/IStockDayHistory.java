package cn.dsgrp.field.stock.grab;

import cn.dsgrp.field.stock.entity.DayDealings;
import cn.dsgrp.field.stock.entity.Dealings;
import cn.dsgrp.field.stock.entity.Stock;

import java.util.Calendar;
import java.util.List;

/**
 * 股票 交易 历史 交易
 * Created by baiqw on 15/8/22.
 */
public interface IStockDayHistory {
    /**
     * 交易历史数据
     * @param stock 股票信息
     * @param date 交易日期
     * @return
     */
    public List<DayDealings> dealingses(Stock stock, Calendar date);
}
