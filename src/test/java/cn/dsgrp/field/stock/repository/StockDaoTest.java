package cn.dsgrp.field.stock.repository;

import cn.dsgrp.field.stock.entity.Market;
import cn.dsgrp.field.stock.entity.Stock;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringContextTestCase;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by baiqw on 15/8/24.
 */
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class StockDaoTest extends SpringContextTestCase {
    @Autowired
    StockDao stockDao;

    @Test
    public void testCrud(){
        Stock stock = new Stock();
        stock.setCode(60000l);
        stock.setSimpleName("中车");
        stock.setMarket(Market.SH_A_MARKET);

        stockDao.save(stock);

        assertThat(stock.getId()).isNotNull();
    }


}
