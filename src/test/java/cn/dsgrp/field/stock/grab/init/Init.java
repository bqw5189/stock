package cn.dsgrp.field.stock.grab.init;

import cn.dsgrp.field.stock.grab.init.impl.MarketImpl;
import cn.dsgrp.field.stock.grab.init.impl.StockImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringContextTestCase;

/**
 * Created by baiqw on 15/8/30.
 */
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class Init extends SpringContextTestCase {
    @Autowired
    private MarketImpl marketImpl;

    @Autowired
    private StockImpl stockImpl;

    @Test
    public void init(){
        //初始化 市场信息
        marketImpl.clean();
        marketImpl.init();

        //初始化  股票信息
        stockImpl.clean();
        stockImpl.init();
    }
}
