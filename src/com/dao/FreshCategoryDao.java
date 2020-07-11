package com.dao;

import java.util.List;

import com.bean.FreshCategory;

public interface FreshCategoryDao extends BaseDao<FreshCategory> {

	FreshCategory getFreshCategoryById(Integer category_id);

	List<FreshCategory> getAllFreshCategory();

	void deleteById(Integer id);

}
