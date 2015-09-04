package cn.dsgrp.field.stock.grab.sh;

import cn.dsgrp.field.stock.entity.Market;
import cn.dsgrp.field.stock.entity.Stock;
import cn.dsgrp.field.stock.grab.IStockDayHistory;
import cn.dsgrp.field.stock.grab.IStockHistory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by baiqw on 15/8/22.
 */
public class SHStockDayHistoryImplTest {
    @Test
    public void dealingses(){

        IStockDayHistory stockDayHistory = new SHStockDayHistoryImpl();

        Calendar date = Calendar.getInstance();
        date.set(2015,7,21);

        Stock stock = new Stock();
        stock.setCode(601766);
        stock.setMarket(Market.SH_A_MARKET);

        System.out.println(JSON.toJSON(stockDayHistory.dealingses(stock, date)));
    }
}
