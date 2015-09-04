package cn.dsgrp.field.stock.grab.sh;

import cn.dsgrp.field.stock.entity.DayDealings;
import cn.dsgrp.field.stock.entity.Dealings;
import cn.dsgrp.field.stock.entity.Stock;
import cn.dsgrp.field.stock.grab.IStockDayHistory;
import cn.dsgrp.field.stock.grab.IStockHistory;
import cn.dsgrp.field.stock.utils.StockUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 沪市 日 历史数据
 * Created by baiqw on 15/8/22.
 */
@Component
public class SHStockDayHistoryImpl implements IStockDayHistory{
    private static final Logger logger = LoggerFactory.logger(SHStockDayHistoryImpl.class);
    /**
     * 上海证券交易所 交易 历史数据
     */
    public static final String HISTORY_URL = "http://money.finance.sina.com.cn/corp/go.php/vMS_MarketHistory/stockid/%d.phtml?year=%d&jidu=%d";

    @Override
    public List<DayDealings> dealingses(Stock stock,Calendar date) {
        List<DayDealings> list = new ArrayList<DayDealings>();

        for (int jd = 1; jd < 2; jd++){
            try {
                logger.info(String.format(HISTORY_URL, stock.getCode(), date.get(Calendar.YEAR), jd));

                Document document = Jsoup.connect(String.format(HISTORY_URL, stock.getCode(), date.get(Calendar.YEAR), jd)).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:40.0) Gecko/20100101 Firefox/40.0").get();

                Elements trs = document.select("#FundHoldSharesTable").select("tbody").select("tr");

                for (int i = 1; i < trs.size(); i++){
                    Element tr = trs.get(i);
                    Elements tds = tr.select("td");
                    DayDealings dayDealings = new DayDealings();

                    dayDealings.setcDate(tds.get(0).text());
                    dayDealings.setOpenPrice(Float.parseFloat(tds.get(1).text()));
                    dayDealings.setMaxPrice(Float.parseFloat(tds.get(2).text()));
                    dayDealings.setClosePrice(Float.parseFloat(tds.get(3).text()));
                    dayDealings.setMinPrice(Float.parseFloat(tds.get(4).text()));
                    dayDealings.setVolumeOfBusiness(Long.parseLong(tds.get(5).text()));
                    dayDealings.setTurnover(Double.parseDouble(tds.get(6).text()));

                    list.add(dayDealings);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return list;
    }




}
