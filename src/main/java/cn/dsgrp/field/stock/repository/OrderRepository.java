/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.dsgrp.field.stock.repository;

import java.util.List;

import cn.dsgrp.field.stock.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Repository to access {@link cn.dsgrp.field.stock.entity.Order}s.
 * 
 * @author Oliver Gierke
 */
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

	/**
	 * Returns all {@link Order}s of the given {@link Customer}.
	 * 
	 * @param customer
	 * @return
	 */
	List<Order> findByName(String name);
}
