package cn.dsgrp.field.stock.grab.sh;

import cn.dsgrp.field.stock.grab.IStockList;
import org.junit.Test;

/**
 * Created by baiqw on 15/8/22.
 */
public class SHAStockListImplTest {
    @Test
    public void list(){

        IStockList stockList = new SHAStockListImpl();

        stockList.list();
    }
}
