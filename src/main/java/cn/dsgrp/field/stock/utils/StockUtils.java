package cn.dsgrp.field.stock.utils;

import cn.dsgrp.field.stock.entity.Dealings;
import cn.dsgrp.field.stock.entity.Market;
import cn.dsgrp.field.stock.entity.Stock;
import com.sun.istack.internal.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;

/**
 * 股票相关工具方法
 * Created by baiqw on 15/8/22.
 */
public class StockUtils {
    /**
     * 获取 市场 标识
     * @param market 市场
     * @return
     */
    public static String getMarketCode(Market market){
        if (null != market.getParentMarket()){
            return getMarketCode(market.getParentMarket());
        }else{
            return market.getCode();
        }
    }

    /**
     * 获取 市场 和 股票 标识
     *
     * 如 sh601766
     *
     * @param stock 股票
     *
     * @return
     */
    public static String getMarketAndStockCode(Stock stock){
        return getMarketCode(stock.getMarket()) + stock.getCode();
    }

    /**
     * 根据 文本 明细 生成 交易 明细 对象
     *
     * 成交时间	成交价	价格变动	成交量(手)	成交额(元)	性质
     * 15:00:03	12.62	-0.01	548	692787	卖盘
     * 14:59:58	12.63	0.01	2640	3335532	买盘
     *
     * @param line 单条数据
     *
     * @return
     */
    public static Dealings parseDealings(String date, @NotNull String line) {
        if (StringUtils.isEmpty(line)){
            throw new IllegalArgumentException("参数不能为空:" + line);
        }

        if (line.startsWith("成交时间")){
            return null;
        }

        String[] datas = StringUtils.split(line, '\t');
        if (datas.length < 6){
            throw new IllegalArgumentException("参数结构错误:参考->14:59:58\t12.63\t0.01\t2640\t3335532\t买盘");
        }




        Dealings dealings = new Dealings();

        try {
            dealings.setDatetimes(DateUtils.parseDate(date + datas[0], "yyyy-MM-ddHH:mm:ss").getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException("成交时间解析错误:" + date + datas[0],e);
        }
        dealings.setcDate(date);
        dealings.setcTime(datas[0]);

        dealings.setPrice(Float.parseFloat(datas[1]));
        dealings.setReadjustPrices(StringUtils.isNumeric(datas[2]) ? Float.parseFloat(datas[2]) : null);
        dealings.setVolumeOfBusiness(Long.parseLong(datas[3]));
        dealings.setTurnover(Double.parseDouble(datas[4]));
        dealings.setNature(datas[5]);


        return dealings;
    }
}
