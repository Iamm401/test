package com.dao.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.Commodity;
import com.dao.CommodityDao;
import com.dao.FreshCategoryDao;
import com.util.JDBCUtils;

public class CommodityDaoImpl extends BaseDaoImpl<Commodity> implements CommodityDao {

	private FreshCategoryDao freshCategoryDao = new FreshCategoryDaoImpl();

	@Override
	public List<Commodity> getCommodityList(Integer offset, Integer size) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "SELECT * FROM `commodity` ORDER BY id,`name` LIMIT ?,?";
			return fillCommodityList(queryList(connection, sql, offset, size));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getCommodityTotal() {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "SELECT COUNT(*) FROM `commodity`";
			return this.get(connection, sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Commodity getCommodityById(Integer id) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "SELECT * FROM `commodity` WHERE `id` = ?";
			return fillCommodity(query(connection, sql, id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Commodity fillCommodity(Commodity commodity) {
		if (commodity == null)
			return commodity;
		commodity.setCategory(freshCategoryDao.getFreshCategoryById(commodity.getCategory_id()));
		return commodity;
	}

	private List<Commodity> fillCommodityList(List<Commodity> commodityList) {
		if (commodityList == null || commodityList.size() == 0)
			return commodityList;
		commodityList.forEach(commodity -> {
			fillCommodity(commodity);
		});
		return commodityList;
	}

	@Override
	public void updateByPrimary(Map<String, Object> params, Integer id) {
		Connection connection = null;
		Map<String, Object> conditionParams = null;
		try {
			connection = JDBCUtils.getConnection();
			conditionParams = new HashMap<String, Object>();
			conditionParams.put("id", id);
			this.update(connection, "commodity", params, conditionParams);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "DELETE FROM `commodity` WHERE id = ?";
			this.execute(connection, sql, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(Commodity commodity) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "INSERT INTO `commodity`(name,price,vip_price,amount,size,details,category_id) VALUES(?,?,?,?,?,?,?)";
			this.execute(connection, sql, commodity.getName(), commodity.getPrice(), commodity.getVip_price(),
					commodity.getAmount(), commodity.getSize(), commodity.getDetails(), commodity.getCategory_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Long getCommodityTotalByCatId(Integer id) {
		Connection connection = null;
		String sql = null;
		try {
			connection = JDBCUtils.getConnection();
			sql = "SELECT COUNT(*) FROM `commodity` WHERE category_id=?";
			return this.get(connection, sql,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
