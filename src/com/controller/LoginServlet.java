package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Employee;
import com.bean.User;
import com.dao.EmployeeDao;
import com.dao.UserDao;
import com.dao.impl.EmployeeDaoImpl;
import com.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UserDao userDao = new UserDaoImpl();
    
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		HttpSession session = request.getSession();
		if("user".equals(userType)) {
			User user = userDao.getUserByAccount(account);
			if(user != null && password.equals(user.getPassword())) {
				response.sendRedirect(request.getContextPath() + "/home");
				return ;
			}
		}else {
			Employee employee = employeeDao.getEmployeeByAccount(account);
			if(employee != null && password.equals(employee.getPassword())) {
				response.sendRedirect(request.getContextPath() + "/employee/home");
				return ;
			}
		}
		request.setAttribute("msg", "账号或密码错误!");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
