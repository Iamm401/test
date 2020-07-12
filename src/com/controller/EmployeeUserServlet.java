package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.util.DateUtil;
import com.util.StringUtils;

/**
 * Servlet implementation class EmployeeUserServlet
 */
@WebServlet("/employee/user")
public class EmployeeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao = new UserDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type == null) {
			List<User> userList = userDao.getUserList();
			request.setAttribute("userList", userList);
			request.setAttribute("nowMenuIndex", 3);
			request.getRequestDispatcher("/WEB-INF/pages/employee/user.jsp").forward(request, response);
		} else if ("upd".equals(type)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			request.setAttribute("user", userDao.getUserById(id));
			request.getRequestDispatcher("/WEB-INF/pages/employee/userInfo.jsp").forward(request, response);
		} else if ("add".equals(type)) {
			request.setAttribute("user", new User());
			request.getRequestDispatcher("/WEB-INF/pages/employee/userInfo.jsp").forward(request, response);
		} else if ("search".equals(type)) {

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if ("upd".equals(type)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			String is_vip = request.getParameter("is_vip");
			String vip_deadline = request.getParameter("vip_deadline");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", StringUtils.UFT8Decoding(name));
			params.put("sex", sex);
			params.put("account", account);
			params.put("password", password);
			params.put("phone", phone);
			params.put("email", email);
			params.put("city", StringUtils.UFT8Decoding(city));
			params.put("is_vip", is_vip);
			if (!StringUtils.isEmpty(vip_deadline))
				params.put("vip_deadline", vip_deadline);
			userDao.updateById(params, id);
			response.sendRedirect(request.getContextPath() + "/employee/user");
		} else if ("del".equals(type)) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			userDao.deleteById(id);
			response.getWriter().append("ok").flush();
		}else if("add".equals(type)) {
			String name = StringUtils.UFT8Decoding(request.getParameter("name"));
			String sex = request.getParameter("sex");
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String city = StringUtils.UFT8Decoding(request.getParameter("city"));
			String is_vip = request.getParameter("is_vip");
			String vip_deadline = request.getParameter("vip_deadline");
			User user = new User(null, name, Integer.valueOf(sex), account, password, phone, email, city, new Date(), Integer.valueOf(is_vip), DateUtil.convertStringToUtil(vip_deadline));
			userDao.add(user);
			response.sendRedirect(request.getContextPath() + "/employee/user");
		}
	}

}
