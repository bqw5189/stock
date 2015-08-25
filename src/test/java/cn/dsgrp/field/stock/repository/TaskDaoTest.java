/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.dsgrp.field.stock.repository;

import cn.dsgrp.field.stock.entity.Task;
import cn.dsgrp.field.stock.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringContextTestCase;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.math.BigInteger;
import java.util.List;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TaskDaoTest extends SpringContextTestCase {

	@Autowired
	private TaskDao taskDao;

	@Test
	public void findTasksByUserId() throws Exception {
		List<Task> tasks = taskDao.findByUser(new User(BigInteger.valueOf(2)));
//		assertThat(tasks.getContent()).hasSize(5);
//		assertThat(tasks.getContent().get(0).getId()).isEqualTo(1);
//		tasks = taskDao.findByUser(new User(BigInteger.valueOf(99999L)), new PageRequest(0, 100, Direction.ASC, "id"));
//		assertThat(tasks.getContent()).isEmpty();
//		assertThat(tasks.getContent()).isEmpty();
	}
}
