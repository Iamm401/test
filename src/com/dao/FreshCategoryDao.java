package com.dao;

import java.util.List;
import java.util.Map;

import com.bean.FreshCategory;

public interface FreshCategoryDao extends BaseDao<FreshCategory> {

	FreshCategory getFreshCategoryById(Integer category_id);

	List<FreshCategory> getAllFreshCategory();

	void deleteById(Integer id);

	void updateById(Map<String, Object> params, Integer id);

	void add(FreshCategory freshCategory);

}
