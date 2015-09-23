package com.eintern.discountmanager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class RemoveEmployeeProgram
 */
public class RemoveEmployeeProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveEmployeeProgram() {
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
		String nameEmployee = request.getParameter("remove_emp_prog");
		if (discountDelegate.removeFromProgram(nameEmployee))
			request.getRequestDispatcher("salesDashboard.jsp").forward(request,
					response);
		else
			request.getRequestDispatcher("salesDashboard.jsp").forward(request,
					response);
	}

}
