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
import com.eintern.discountmanager.models.Program;
import com.eintern.discountmanager.models.Vendor;
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class employeeServlet
 */
public class employeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public employeeServlet() {
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

		session.getAttribute("current_user");
		// List<Program> list = dao.getPrograms();
		List<Program> list = discountDelegate.getAllPrograms();
		int num = 1;
		int discount_size = 0;

		out.println("<table class='table table-bordered'><thead><tr><td>Program Name</td><td>Vendor(s)</td><td>Discount(s)</td></tr></thead>");
		out.println("<tbody>");
		session.setAttribute("list_programs", list);
		if (list != null) {
			for (Program p : list) {
				++num;
				Set<Vendor> set = p.getVendors();
				set.size();
				discount_size = 0;
				for (Vendor v : set) {
					discount_size += v.getDiscounts().size();
				}

				out.println("<tr><td rowspan='" + discount_size + "'>"
						+ p.getName());
				out.println("<br/><form method=\"post\" action=\"enrollServlet\">"
						+ "<button id=\"enroll"
						+ num
						+ "\" class=\"btn btn-primary\" value=\""
						+ p.getName()
						+ "\""
						+ " name=\"enroll\""
						+ ">Enroll</button></form></td>");
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

			}
			out.println("</tbody></table>");
		} else {
			out.println("There are no programs in the database.");
		}
		session.setAttribute("num_programs", num);

	}

}
