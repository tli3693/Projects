package com.eintern.discountmanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.eintern.discountmanager.models.Vendor;

/**
 * Servlet implementation class EmpProgram
 */
public class EmpProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpProgram() {
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

		Employee e = (Employee) session.getAttribute("current_user");
		int discount_size = 0;
		if (e.getProgram() != null) {

			Program p = e.getProgram();
			Set<Vendor> set = p.getVendors();
			for (Vendor v : set) {
				discount_size += v.getDiscounts().size();
			}

			out.println("You are enrolled in the " + p.getName()
					+ " program.<br/>");
			out.println("<table class='table table-bordered'><thead><tr><td>Program Name</td><td>Vendor(s)</td><td>Discount(s)</td></tr></thead>");
			out.println("<tbody>");
			out.println("<tr><td rowspan='" + discount_size + "'>"
					+ p.getName());
			out.println("<br/><form method=\"post\" action=\"unEnrollServlet\">"
					+ "<button id=\"unenroll"
					+ "\" class=\"btn btn-primary btn-sm\" value=\""
					+ p.getName()
					+ "\""
					+ " name=\"unenroll\""
					+ ">Unenroll</button></form></td>");

			for (Vendor v : set) {
				Set<Discount> discounts = v.getDiscounts();
				discount_size = discounts.size();
				out.println("<td rowspan='" + discount_size + "'>"
						+ v.getName() + "</td>");
				int n = 0;
				// out.println("<br/>");
				for (Discount d : discounts) {
					if (n % 2 == 0) {
						out.println("<td>" + d.getName() + ": "
								+ d.getPercent() + "% off</td></tr>");
						n++;
					} else
						out.println("<tr><td>" + d.getName() + ": "
								+ d.getPercent() + "% off</td></tr>");
				}
			}
			out.println("</tbody></table>");
			// for (Vendor v : set) {
			// out.println("Vendor: " + v.getName());
			// Set<Discount> discounts = v.getDiscounts();
			// out.println("<br/>");
			// for (Discount d : discounts) {
			// out.println(d.getName() + ": " + d.getPercent()
			// + "% off! <br/>");
			// }
			// }
		} else {
			out.println("You are not in a program.");
		}
	}

}
