package com.dao;

import java.util.List;
import java.util.Map;

import com.bean.Commodity;

public interface CommodityDao extends BaseDao<Commodity> {

	List<Commodity> getCommodityList(Integer offset, Integer size);

	Long getCommodityTotal();

	Commodity getCommodityById(Integer id);

	void updateByPrimary(Map<String, Object> params, Integer id);

	void deleteById(Integer id);

	void add(Commodity commodity);

	Long getCommodityTotalByCatId(Integer id);


}
