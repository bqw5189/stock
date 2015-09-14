/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.dsgrp.field.stock.repository;

import cn.dsgrp.field.stock.entity.DayDealings;
import cn.dsgrp.field.stock.entity.Stock;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface DayDealingsDao extends PagingAndSortingRepository<DayDealings, Long> {

    @Query("{stock.code:?0,cDate:?1}")
    public List<DayDealings> findByStockCodeAndCdate(int code, String s);
}
