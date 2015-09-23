package com.eintern.discountmanager.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class CreateProgram
 */
public class CreateProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProgram() {
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
		String name_prog = request.getParameter("program_name");
		String[] results = request.getParameterValues("add_vendors");
		if (name_prog != null) {
			// Program p = new Program();
			// p.setName(name_prog);
			//
			// dao.saveObject(p);
			// p = dao.getProgramByName(name_prog);
			// Vendor v = null;
			// for (int i = 0; i < results.length; i++) {
			// System.out.println(results[i]);
			// v = dao.getVendorByName(results[i]);
			// dao.addVendor(v.getUserId(), p.getId());
			// }
			discountDelegate.createProgram(name_prog, results);
			request.getRequestDispatcher("program_created.jsp").forward(
					request, response);

		} else {
			request.getRequestDispatcher("program_failed.jsp").forward(request,
					response);
		}
	}

}
