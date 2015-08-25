/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.dsgrp.field.stock.data;

import cn.dsgrp.field.stock.entity.Task;
import cn.dsgrp.field.stock.entity.User;
import org.springside.modules.test.data.RandomData;

import java.math.BigInteger;

/**
 * Task相关实体测试数据生成.
 * 
 * @author calvin
 */
public class TaskData {

	public static Task randomTask() {
		Task task = new Task();
		task.setTitle(randomTitle());
		User user = new User(BigInteger.valueOf(1));
		task.setUser(user);
		return task;
	}

	public static String randomTitle() {
		return RandomData.randomName("Task");
	}
}
