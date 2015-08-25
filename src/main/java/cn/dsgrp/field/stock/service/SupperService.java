package cn.dsgrp.field.stock.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by baiqunwei on 15/6/9.
 */
public abstract class SupperService<T> {

    public abstract CrudRepository<T, Long> getDao();

    public T get(Long id) {
        return getDao().findOne(id);
    }

    public void save(T entity) {
        getDao().save(entity);
    }

    public void delete(Long id) {
        getDao().delete(id);
    }

    public List<T> getAll() {
        return (List<T>) getDao().findAll();
    }

    /**
     * 创建分页请求.
     */
    public PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "id");
        } else {
            if (sortType.indexOf("@") > -1) {
                String sorts[] = sortType.split("@");
                sort = new Sort(Sort.Direction.fromString(sorts[1]), sorts[0]);
            } else {
                sort = new Sort(Sort.Direction.DESC, sortType);
            }
        }

        if (pageNumber <= 0) {
            pageNumber = 0;
        }
        if (pagzSize < 0) {
            pagzSize = 10;
        }
        return new PageRequest(pageNumber, pagzSize, sort);
    }

//    /**
//     * 创建动态查询条件组合.
//     */
//    public Specification<T> buildSpecification(Map<String, ? extends Object> searchParams) {
//        Map<String, SearchFilter> filters = SearchFilter.parse((Map<String, Object>) searchParams);
//        @SuppressWarnings("unchecked")
//        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        Specification<T> spec = DynamicSpecifications.bySearchFilter(filters.values(), entityClass);
//        return spec;
//    }


}
