package com.eintern.discountmanager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eintern.discountmanager.DAO.DiscountManagerDAO;
import com.eintern.discountmanager.models.User;
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUser() {
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
		DiscountManagerDAO dao = new DiscountManagerDAO();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("current_user");
		
		if (pwd != null && pwd2 != null) {
			discountDelegate.updateUser(user, email, fname, lname);
			request.getRequestDispatcher("myaccount.jsp").forward(request,
					response);
		} else {
			discountDelegate.updateUser(user, email, fname, lname, pwd, pwd2);
			request.getRequestDispatcher("myaccount.jsp").forward(request,
					response);

		}
	}

}
