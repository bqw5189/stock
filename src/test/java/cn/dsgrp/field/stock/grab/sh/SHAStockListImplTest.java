package cn.dsgrp.field.stock.grab.sh;

import cn.dsgrp.field.stock.entity.Stock;
import cn.dsgrp.field.stock.grab.IStockList;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * Created by baiqw on 15/8/22.
 */
public class SHAStockListImplTest {
    @Test
    public void list(){

        IStockList stockList = new SHAStockListImpl();

        List<Stock> stocks = stockList.list();

        System.out.println(JSON.toJSONString(stocks));


    }
}
