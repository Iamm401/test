package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Commodity;
import com.bean.FreshCategory;
import com.dao.CommodityDao;
import com.dao.FreshCategoryDao;
import com.dao.impl.CommodityDaoImpl;
import com.dao.impl.FreshCategoryDaoImpl;
import com.util.StringUtils;

/**
 * Servlet implementation class EmployeeCommodityServlet
 */
@WebServlet("/employee/commodity")
public class EmployeeCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommodityDao commodityDao = new CommodityDaoImpl();
	
	private FreshCategoryDao freshCategoryDao = new FreshCategoryDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		if ("upd".equals(type)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			Commodity commodity = commodityDao.getCommodityById(id);
			List<FreshCategory> freshCategoryList = freshCategoryDao.getAllFreshCategory();
			request.setAttribute("commodity", commodity);
			request.setAttribute("freshCategoryList", freshCategoryList);
			request.getRequestDispatcher("/WEB-INF/pages/employee/commodityInfo.jsp").forward(request, response);
		} else if ("del".equals(type)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			commodityDao.deleteById(id);
			response.sendRedirect(request.getContextPath() + "/employee/home");
		}else if("add".equals(type)) {
			List<FreshCategory> freshCategoryList = freshCategoryDao.getAllFreshCategory();
			request.setAttribute("commodity", new Commodity());
			request.setAttribute("freshCategoryList", freshCategoryList);
			request.getRequestDispatcher("/WEB-INF/pages/employee/commodityInfo.jsp").forward(request, response);;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		if("upd".equals(type)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			String name =StringUtils.UFT8Decoding(request.getParameter("name"));
			String price = request.getParameter("price");
			String vip_price = request.getParameter("vip_price");
			String amount = request.getParameter("amount");
			String size = request.getParameter("size");
			String details =StringUtils.UFT8Decoding(request.getParameter("details"));
			String category_id = request.getParameter("category_id");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", name);
			params.put("price", price);
			params.put("vip_price", vip_price);
			params.put("amount", amount);
			params.put("size", size);
			params.put("details", details);
			params.put("category_id", category_id);
			commodityDao.updateByPrimary(params,id);
			response.sendRedirect(request.getContextPath() + "/employee/home");
		}else if("add".equals(type)){
			String name =StringUtils.UFT8Decoding(request.getParameter("name"));
			String price = request.getParameter("price");
			String vip_price = request.getParameter("vip_price");
			String amount = request.getParameter("amount");
			String size = request.getParameter("size");
			String details =StringUtils.UFT8Decoding(request.getParameter("details"));
			String category_id = request.getParameter("category_id");
			Commodity commodity = new Commodity(null, name, Double.valueOf(price), Double.valueOf(vip_price), Integer.valueOf(amount), Integer.valueOf(size), details, Integer.valueOf(category_id), null);
			commodityDao.add(commodity);
			response.sendRedirect(request.getContextPath() + "/employee/home");
		}
	}

}
