/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.dsgrp.field.stock.repository;

import cn.dsgrp.field.stock.entity.Market;
import cn.dsgrp.field.stock.entity.Stock;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MarketDao extends PagingAndSortingRepository<Market, Long> {



}
