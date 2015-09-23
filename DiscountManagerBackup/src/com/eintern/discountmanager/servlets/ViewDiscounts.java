package com.eintern.discountmanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eintern.discountmanager.models.Discount;
import com.eintern.discountmanager.models.Vendor;

/**
 * Servlet implementation class ViewDiscounts
 */
public class ViewDiscounts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewDiscounts() {
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

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Vendor v = (Vendor) session.getAttribute("current_user");
		Set<Discount> discounts = v.getDiscounts();
		int num = 1;
		int num2 = 2;

		out.println("<h1>" + v.getName() + " discounts</h1> <br/>");
		out.println("<table class='table table-bordered'><thead><tr><td>Discount</td><td>Percentage Off</td><td>Action</td></tr></thead>");
		out.println("<tbody>");
		for (Discount d : discounts) {
			out.println("<tr><td>" + d.getName() + "</td><td> "
					+ d.getPercent() + "% off</td>");
			out.println("<td><form method='post' action='RemoveDiscount'><button id=\"remove_discount"
					+ num
					+ "\" value=\""
					+ d.getName()
					+ "\""
					+ " class=\"btn btn-primary btn-sm remove_discount\" class=\"remove_discount\" name=\"remove_discount\""
					+ ">Remove Discount</button></form>");
			out.println("<form method='post' action='EditDiscount'><button id=\"edit_discount"
					+ num2
					+ "\" value=\""
					+ d.getName()
					+ "\""
					+ " class=\"btn btn-primary btn-sm edit_discount edit_discount\"  name=\"edit_discount\""
					+ ">Edit Discount</button> <br/></form></td>");
			++num;
			++num2;
		}
		out.println("</tbody></table>");

	}
}