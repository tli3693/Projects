package com.eintern.discountmanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eintern.discountmanager.DAO.DiscountManagerDAO;
import com.eintern.discountmanager.models.Employee;
import com.eintern.discountmanager.models.Program;
import com.eintern.discountmanager.models.User;
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class unEnrollServlet
 */
public class unEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public unEnrollServlet() {
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
		HttpSession session = request.getSession();
		Employee u = (Employee) session.getAttribute("current_user");
		PrintWriter out = response.getWriter();
		int id = u.getUserId();

		if (discountDelegate.unenrollInProgram(u) != null) {
			request.getRequestDispatcher("employeeDashboard.jsp").forward(
					request, response);
			session.setAttribute("current_user",
					discountDelegate.getUser(u.getUsername()));
			out.println("Successfully enrolled!");
		} else {
			request.getRequestDispatcher("employeeDashboard.jsp").forward(
					request, response);
			out.println("COULD NOT UNENROLL!!");
		}
	}

}
