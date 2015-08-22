package cn.dsgrp.field.stock.grab.sh;

import cn.dsgrp.field.stock.entity.ListedCompany;
import cn.dsgrp.field.stock.entity.Market;
import cn.dsgrp.field.stock.entity.Stock;
import cn.dsgrp.field.stock.grab.IStockList;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 沪市 A 股 列表
 * Created by baiqw on 15/8/22.
 */
public class SHAStockListImpl implements IStockList{
    /**
     * 上海证券交易所 A 股 列表
     */
    public static final String LIST_URL = "http://query.sse.com.cn/commonQuery.do?jsonCallBack=jsonpCallback26259&isPagination=true&sqlId=COMMON_SSE_ZQPZ_GPLB_MCJS_SSAG_L&pageHelp.pageSize=1000&_=1440216123008";

    @Override
    public List<Stock> list() {
        List<Stock> list = new ArrayList<Stock>();

        try {
            String callBack = Jsoup.connect(LIST_URL).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:40.0) Gecko/20100101 Firefox/40.0").header("Content-Type", "application/json").ignoreContentType(true).referrer("http://www.sse.com.cn/assortment/stock/list/name/").method(Connection.Method.GET).execute().body();

            String jsonData = callBack.substring(callBack.indexOf("{"), callBack.lastIndexOf("}") + 1);

            JSONObject responseObject = JSON.parseObject(jsonData);

            System.out.println("responseObject:" + responseObject);

            JSONArray stockArray = responseObject.getJSONObject("pageHelp").getJSONArray("data");

            for (int i = 0; i < stockArray.size(); i++){
                JSONObject stockRow = stockArray.getJSONObject(i);

                Stock stock = new Stock();
                stock.setCode(stockRow.getLong("PRODUCTID"));
                stock.setSimpleName(stockRow.getString("PRODUCTNAME"));

                ListedCompany listedCompany = new ListedCompany();
                listedCompany.setCode(stock.getCode());
                listedCompany.setSimpleName(stock.getSimpleName());
                listedCompany.setFullName(stockRow.getString("FULLNAME"));

                stock.setListedCompany(listedCompany);
                stock.setMarket(Market.SH_A_MARKET);

                list.add(stock);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }




}
