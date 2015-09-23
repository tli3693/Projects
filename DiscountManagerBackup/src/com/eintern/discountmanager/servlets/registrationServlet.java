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
import com.eintern.discountmanager.models.Vendor;
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class registrationServlet
 */
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registrationServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		HttpSession session = request.getSession();
		String dashboard = null;

		if (role.equals("emp")) {
			Employee e = (Employee) discountDelegate.registerNewUser(username,
					password, email, role, firstname, lastname);
			dashboard = "employeeDashboard.jsp";
			session.setAttribute("current_user", e);
			request.getRequestDispatcher(dashboard).forward(request, response);

		} else if (role.equals("sales")) {
			SalesTeam s = (SalesTeam) discountDelegate.registerNewUser(
					username, password, email, role, firstname, lastname);
			dashboard = "salesDashboard.jsp";
			session.setAttribute("current_user", s);
			request.getRequestDispatcher(dashboard).forward(request, response);

		} else if (role.equals("vendor")) {
			String vendorName = request.getParameter("vendor_name");
			Vendor v = discountDelegate.registerNewUser(username, password,
					email, role, firstname, lastname, vendorName);
			dashboard = "vendorDashboard.jsp";
			session.setAttribute("current_user", v);

			System.out.println("Registration successful!");
			request.getRequestDispatcher(dashboard).forward(request, response);
		}
	}

}
