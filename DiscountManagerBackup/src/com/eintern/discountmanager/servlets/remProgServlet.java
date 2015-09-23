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
import com.eintern.discountmanager.models.Program;
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class remProgServlet
 */
public class remProgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public remProgServlet() {
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
		String program = request.getParameter("remove_prog");
		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();

		List<Program> list = discountDelegate.getAllPrograms();
		if (discountDelegate.removeProgram(list, program)) {
			request.getRequestDispatcher("salesDashboard.jsp").forward(
					request, response);
		} else
			request.getRequestDispatcher("salesDashboard.jsp").forward(
					request, response);

	}

}
