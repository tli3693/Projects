package com.eintern.discountmanager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eintern.discountmanager.DAO.DiscountManagerDAO;
import com.eintern.discountmanager.models.Employee;
import com.eintern.discountmanager.models.SalesTeam;
import com.eintern.discountmanager.models.User;
import com.eintern.discountmanager.models.Vendor;
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		switch (discountDelegate.checkLoginCredentials(username, password)) {
		case 0:
			response.sendRedirect("loginfailure.jsp");
			break;
		case 1:
			Employee e = (Employee) discountDelegate.getUser(username);
			session.setAttribute("current_user", e);
			request.getRequestDispatcher("employeeDashboard.jsp").forward(
					request, response);
			break;
		case 2:
			Vendor v = (Vendor) discountDelegate.getUser(username);
			session.setAttribute("current_user", v);
			request.getRequestDispatcher("vendorDashboard.jsp").forward(
					request, response);
			break;
		case 3:
			SalesTeam s = (SalesTeam) discountDelegate.getUser(username);
			session.setAttribute("current_user", s);
			request.getRequestDispatcher("salesDashboard.jsp").forward(request,
					response);
			break;
		}

		response.sendRedirect("loginfailure.jsp");

		// int userId = 0;
		// if (dao.checkUserPassword(username, password)) {
		// System.out.println("Username password is correct!");
		// switch (dao.checkRole(username)) {
		// case 0:
		// response.sendRedirect("loginfailure.jsp");
		// break;
		// case 1:
		// dashboard = "employeeDashboard.jsp";
		// userId = dao.getUserId(username);
		// Employee e = dao.getEmployee(userId);
		// session.setAttribute("current_user", e);
		// break;
		// case 2:
		// dashboard = "vendorDashboard.jsp";
		// userId = dao.getUserId(username);
		// Vendor v = (Vendor) dao.getVendor(userId);
		// session.setAttribute("current_user", v);
		// break;
		// case 3:
		// dashboard = "salesDashboard.jsp";
		// userId = dao.getUserId(username);
		// SalesTeam s = (SalesTeam) dao.getUser(userId);
		// session.setAttribute("current_user", s);
		// break;
		//
		// }
		//
		// request.getRequestDispatcher(dashboard).forward(request, response);
		//
		// } else {
		//
		// response.sendRedirect("loginfailure.jsp");
		// }
	}
}
