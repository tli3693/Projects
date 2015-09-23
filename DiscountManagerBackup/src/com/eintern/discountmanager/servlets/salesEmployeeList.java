package com.eintern.discountmanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eintern.discountmanager.DAO.DiscountManagerDAO;
import com.eintern.discountmanager.models.Discount;
import com.eintern.discountmanager.models.Employee;
import com.eintern.discountmanager.models.Program;
import com.eintern.discountmanager.models.SalesTeam;
import com.eintern.discountmanager.models.Vendor;
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class salesEmployeeList
 */
public class salesEmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public salesEmployeeList() {
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
		PrintWriter out = response.getWriter();

		List<Employee> list = discountDelegate.getAllEmployees();
		int num = 1;

		session.setAttribute("list_employees", list);

		for (Employee emp : list) {
			out.println("Employee ID: " + emp.getUserId() + "<br/>");
			out.println("Employee Name: " + emp.getFirstname() + " "
					+ emp.getLastname() + "<br/>");
			if (emp.getProgram() != null) {
				Program p = emp.getProgram();
				out.println("<br/><div> Program name: " + p.getName());
				out.println("<form method=\"post\" action=\"remProgServlet\">"
						+ "<button id=\"remove_prog" + num
						+ "\" class=\"btn btn-danger\" value=\"" + p.getName()
						+ "\"" + " name=\"remove_prog\""
						+ ">Remove</button></form>");
				out.println("<form method=\"post\" action=\"updProgServlet\">"
						+ "<button id=\"update_prog" + num
						+ "\" class=\"btn btn-info\" value=\"" + p.getName()
						+ "\"" + " name=\"update_prog\""
						+ ">Edit</button></form>");
				++num;
				Set<Vendor> set = p.getVendors();

				out.println("<br/>");
				for (Vendor v : set) {
					out.println("Vendor: " + v.getName());
					Set<Discount> discounts = v.getDiscounts();
					out.println("<br/>");
					for (Discount d : discounts) {
						out.println(d.getName() + ": " + d.getPercent()
								+ "% off! <br/>");
					}
				}
				out.println("<br/><br/>");
				out.println("</div>");
			}
		}
	}

}
