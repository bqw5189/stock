package cn.dsgrp.field.stock.repository;

import cn.dsgrp.field.stock.entity.Market;
import cn.dsgrp.field.stock.entity.Stock;
import org.eclipse.jetty.util.ajax.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringContextTestCase;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by baiqw on 15/8/24.
 */
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DayDealingsDaoTest extends SpringContextTestCase {
    @Autowired
    DayDealingsDao dayDealingsDao;

    @Test
    public void testCrud(){
        assertThat(dayDealingsDao.findByStockCodeAndCdate(601766, "2015-02-27").size()).isEqualTo(1);
        System.out.println(JSON.toString(dayDealingsDao.findByStockCodeAndCdate(601766, "2015-02-27")));
    }
}


