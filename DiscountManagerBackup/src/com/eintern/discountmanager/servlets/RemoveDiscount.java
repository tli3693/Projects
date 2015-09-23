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
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class RemoveDiscount
 */
public class RemoveDiscount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveDiscount() {
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

		String disc = request.getParameter("remove_discount");
		HttpSession session = request.getSession();
		Vendor v = (Vendor) session.getAttribute("current_user");
		PrintWriter out = response.getWriter();
		Set<Discount> discounts = v.getDiscounts();

		if (discountDelegate.removeDiscount(discounts, v, disc)) {
			session.setAttribute("current_user",
					discountDelegate.getUser(v.getUsername()));
			request.getRequestDispatcher("vendorDashboard.jsp").forward(
					request, response);
		}
		// for (Discount d : discounts) {
		// if (disc.equals(d.getName())) {
		// dao.removeDiscount(d.getId(), v.getUserId());
		// out.println("Successfully removed discount for " + d.getName());
		// break;
		// } else {
		// out.println("Could not find discount in database.");
		// }
		// }
	}
}
