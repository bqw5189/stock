/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.dsgrp.field.stock.repository;

import cn.dsgrp.field.stock.entity.Task;
import cn.dsgrp.field.stock.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TaskDao extends PagingAndSortingRepository<Task, Long>{

	List<Task> findByUser(User user);


}
