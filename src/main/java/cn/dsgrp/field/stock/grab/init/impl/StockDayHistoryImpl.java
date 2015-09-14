package cn.dsgrp.field.stock.grab.init.impl;

import cn.dsgrp.field.stock.entity.Market;
import cn.dsgrp.field.stock.entity.Stock;
import cn.dsgrp.field.stock.grab.IStockDayHistory;
import cn.dsgrp.field.stock.grab.init.IInit;
import cn.dsgrp.field.stock.grab.sh.SHAStockListImpl;
import cn.dsgrp.field.stock.grab.sh.SHStockDayHistoryImpl;
import cn.dsgrp.field.stock.repository.DayDealingsDao;
import cn.dsgrp.field.stock.repository.StockDao;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

/**
 * Created by baiqw on 15/8/30.
 */
@Component
public class StockDayHistoryImpl implements IInit{
    private static final Logger logger = LoggerFactory.getLogger(StockDayHistoryImpl.class);

    @Autowired
    private StockDao stockDao;

    @Autowired
    private DayDealingsDao dayDealingsDao;

    @Override
    public void clean() {
        logger.debug("Begin clean ...");
        stockDao.deleteAll();
        logger.debug("Finish clean .");
    }

    @Override
    public void init() {
        logger.debug("Begin clean ...");

        IStockDayHistory stockDayHistory = new SHStockDayHistoryImpl();

        Calendar date = Calendar.getInstance();
        date.set(2015,7,21);

        Stock stock = new Stock();
        stock.setCode(601766);
        stock.setMarket(Market.SH_A_MARKET);

        dayDealingsDao.save(stockDayHistory.dealingses(stock, date));

        logger.debug("Finish clean .");
    }
}
