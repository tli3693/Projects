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
import com.eintern.discountmanager.models.Vendor;
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class ListEmployees
 */
public class ListEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListEmployees() {
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
		// List<Employee> list = dao.getEmployees();
		List<Employee> list = discountDelegate.getAllEmployees();
		int num = 1;

		session.setAttribute("list_employees", list);

		out.println("Employee Table<br/>");
		out.println("<table class='table table-bordered'><thead><tr><td>Username</td><td>Employee Name</td><td>Program Name</td><td>Vendor(s)</td><td>Discount(s)</td></tr></thead>");
		out.println("<tbody>");

		for (Employee emp : list) {
			// out.println("Employee ID: " + emp.getUserId() + "<br/>");
			int discount_size = 0;
			if (emp.getProgram() != null) {
				++num;
				Program p = emp.getProgram();
				Set<Vendor> set = p.getVendors();
				set.size();
				discount_size = 0;
				for (Vendor v : set) {
					discount_size += v.getDiscounts().size();
				}
				out.println("<tr><td rowspan='" + discount_size + "'>"
						+ emp.getUsername() + "</td>");
				out.println("<td <td rowspan='" + discount_size + "'>"
						+ emp.getFirstname() + " " + emp.getLastname()
						+ "</td>");

				out.println("<td rowspan='" + discount_size + "'>"
						+ p.getName());
				out.println("<br/><form method=\"post\" action=\"RemoveEmployeeProgram\">"
						+ "<button id=\"remove_prog"
						+ num
						+ "\" class=\"btn btn-danger\" value=\""
						+ emp.getUserId()
						+ "\""
						+ " name=\"remove_emp_prog\""
						+ ">Remove</button></form></td>");
				// out.println("<br/>");
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

				// out.println("</div>");
			} else {
				out.println("<td>Not in a program</td><td>-</td><td>-</td></tr>");
			}

		}
		out.println("</tbody></table>");

	}

}
