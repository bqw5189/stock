/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.dsgrp.field.stock.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import cn.dsgrp.field.stock.entity.User;

import java.math.BigInteger;

public interface UserDao extends PagingAndSortingRepository<User, BigInteger> {
	User findByLoginName(String loginName);
}
