package cn.dsgrp.field.stock.grab.init.impl;

import cn.dsgrp.field.stock.entity.Market;
import cn.dsgrp.field.stock.grab.init.IInit;
import cn.dsgrp.field.stock.repository.MarketDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by baiqw on 15/8/30.
 */
@Component
public class MarketImpl implements IInit{
    private static final Logger logger = LoggerFactory.getLogger(MarketImpl.class);

    @Autowired
    private MarketDao marketDao;

    @Override
    public void clean() {
        logger.debug("Begin clean ...");
        marketDao.deleteAll();
        logger.debug("Finish clean .");
    }

    @Override
    public void init() {
        logger.debug("Begin clean ...");
        marketDao.save(Market.SH_MARKET);
        marketDao.save(Market.SH_A_MARKET);
        marketDao.save(Market.SH_B_MARKET);
        logger.debug("Finish clean .");
    }
}
