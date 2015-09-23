package com.eintern.discountmanager.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eintern.discountmanager.models.Vendor;
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class CreateDiscount
 */
public class CreateDiscount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateDiscount() {
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

		// DiscountManagerDAO dao = new DiscountManagerDAO();
		String name = request.getParameter("discount_name");
		String percent = request.getParameter("percent");
		HttpSession session = request.getSession();
		Vendor v = (Vendor) session.getAttribute("current_user");
		//
		// Discount d = new Discount();
		// d.setName(name);
		// d.setPercent(Integer.parseInt(percent));
		//
		// dao.saveObject(d);
		//
		// Discount d2 = dao.getDiscountWithName(d.getName());
		// dao.addDiscount(d2.getId(), v.getUserId());
		// Vendor v1 = (Vendor) dao.getVendor(v.getUserId());

		discountDelegate.createDiscount(v, name, Integer.parseInt(percent));
		Vendor v1 = (Vendor) discountDelegate.getUser(v.getUsername());
		session.setAttribute("current_user", v1);

		request.getRequestDispatcher("discount_success.jsp").forward(request,
				response);

	}

}