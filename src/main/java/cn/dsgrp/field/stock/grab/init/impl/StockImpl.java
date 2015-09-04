package cn.dsgrp.field.stock.grab.init.impl;

import cn.dsgrp.field.stock.entity.Market;
import cn.dsgrp.field.stock.entity.Stock;
import cn.dsgrp.field.stock.grab.init.IInit;
import cn.dsgrp.field.stock.grab.sh.SHAStockListImpl;
import cn.dsgrp.field.stock.repository.MarketDao;
import cn.dsgrp.field.stock.repository.StockDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by baiqw on 15/8/30.
 */
@Component
public class StockImpl implements IInit{
    private static final Logger logger = LoggerFactory.getLogger(StockImpl.class);

    @Autowired
    private StockDao stockDao;

    @Autowired
    private SHAStockListImpl sHAStockListImpl;

    @Override
    public void clean() {
        logger.debug("Begin clean ...");
        stockDao.deleteAll();
        logger.debug("Finish clean .");
    }

    @Override
    public void init() {
        logger.debug("Begin clean ...");
        List<Stock> stockList = sHAStockListImpl.list();

        stockDao.save(stockList);

        logger.debug("Finish clean .");
    }
}
