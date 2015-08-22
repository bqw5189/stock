package cn.dsgrp.field.stock.grab.sh;

import cn.dsgrp.field.stock.entity.Dealings;
import cn.dsgrp.field.stock.entity.ListedCompany;
import cn.dsgrp.field.stock.entity.Market;
import cn.dsgrp.field.stock.entity.Stock;
import cn.dsgrp.field.stock.grab.IStockHistory;
import cn.dsgrp.field.stock.grab.IStockList;
import cn.dsgrp.field.stock.utils.StockUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 沪市 历史数据
 * Created by baiqw on 15/8/22.
 */
public class SHStockHistoryImpl implements IStockHistory{
    /**
     * 上海证券交易所 交易 历史数据
     */
    public static final String HISTORY_URL = "http://market.finance.sina.com.cn/downxls.php?date=%s&symbol=%s";

    @Override
    public List<Dealings> dealingses(Stock stock,Calendar date) {
        String dateStr = DateFormatUtils.format(date, "yyyy-MM-dd");
        String stockCode = StockUtils.getMarketAndStockCode(stock);


        List<Dealings> list = new ArrayList<Dealings>();

        try {
            System.out.println(String.format(HISTORY_URL, dateStr, stockCode));

            LineIterator dealingses = IOUtils.lineIterator(new URL(String.format(HISTORY_URL, dateStr, stockCode)).openStream(), "gb2312");

            while(dealingses.hasNext()){
                String line = dealingses.nextLine();

                Dealings dealings = StockUtils.parseDealings(dateStr, line);

                if (null !=dealings) {
                    list.add(dealings);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }




}
