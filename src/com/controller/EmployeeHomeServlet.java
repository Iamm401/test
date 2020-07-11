package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Commodity;
import com.dao.CommodityDao;
import com.dao.impl.CommodityDaoImpl;

/**
 * Servlet implementation class EmployeeHomeServlet
 */
@WebServlet("/employee/home")
public class EmployeeHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommodityDao commodityDao = new CommodityDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer pageNum = Integer
				.valueOf((request.getParameter("pageNum") == null ? "1" : request.getParameter("pageNum")));
		Integer pageSize = Integer
				.valueOf((request.getParameter("pageSize") == null ? "10" : request.getParameter("pageSize")));
		Long total = commodityDao.getCommodityTotal();
		Integer totalPage = (int) Math.ceil(total * 1.0 / pageSize);
		if (totalPage < pageNum) {
			pageNum = totalPage;
		}
		Integer offset = (pageNum - 1) * pageSize;
		List<Commodity> commodityList = commodityDao.getCommodityList(offset, pageSize);
		Integer begin = pageNum;
		Integer end = pageNum + 4;
		if(end > totalPage) {
			begin = pageNum - (end - totalPage);
			end = totalPage;
		}
		if(begin <= 0) {
			begin = 1;
		}
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
		request.setAttribute("total", total);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("commodityList", commodityList);
		request.setAttribute("nowMenuIndex", 1);
		request.getRequestDispatcher("/WEB-INF/pages/employee/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
