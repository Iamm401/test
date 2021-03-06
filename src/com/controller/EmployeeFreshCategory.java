package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.FreshCategory;
import com.dao.CommodityDao;
import com.dao.FreshCategoryDao;
import com.dao.impl.CommodityDaoImpl;
import com.dao.impl.FreshCategoryDaoImpl;
import com.util.StringUtils;

/**
 * Servlet implementation class EmployeeFreshCategory
 */
@WebServlet("/employee/fresh_category")
public class EmployeeFreshCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private FreshCategoryDao freshCategoryDao = new FreshCategoryDaoImpl();
    
    private CommodityDao commodityDao = new CommodityDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type == null) {
			List<FreshCategory> freshCategoryList = freshCategoryDao.getAllFreshCategory();
			request.setAttribute("freshCategoryList", freshCategoryList);
			request.setAttribute("nowMenuIndex", 2); 
			request.getRequestDispatcher("/WEB-INF/pages/employee/freshCategory.jsp").forward(request, response);
		}else if("upd".equals(type)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			request.setAttribute("freshCategory", freshCategoryDao.getFreshCategoryById(id));
			request.getRequestDispatcher("/WEB-INF/pages/employee/freshCategoryInfo.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if("del".equals(type)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			Long total = commodityDao.getCommodityTotalByCatId(id);
			if(total > 0) {
				response.getWriter().append("error").flush();
			}else {
				freshCategoryDao.deleteById(id);
				response.getWriter().append("ok").flush();
			}
		}else if("upd".equals(type)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			String name = StringUtils.UFT8Decoding(request.getParameter("name"));
			String desc = StringUtils.UFT8Decoding(request.getParameter("desc"));
			response.sendRedirect(request.getContextPath() + "/employee/fresh_category");
		}
	}

}
