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
import com.eintern.discountmanager.models.Employee;
import com.eintern.discountmanager.models.Program;
import com.eintern.discountmanager.models.delegate.DiscountDelegate;

/**
 * Servlet implementation class enrollServlet
 */
public class enrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DiscountDelegate discountDelegate = new DiscountDelegate();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public enrollServlet() {
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
		String program = request.getParameter("enroll");

		HttpSession session = request.getSession();
		Employee u = (Employee) session.getAttribute("current_user");
		PrintWriter out = response.getWriter();
		int id = u.getUserId();

		List<Program> list = discountDelegate.getAllPrograms();

		if (program == null) {
			out.println(program);
		} else {
			if (u.getProgram() == null) {
				for (Program p : list) {
					if (program.equals(p.getName())) {
						// dao.enrollInProgram(id, p.getId());
						Employee e = discountDelegate.enrollInProgram(id,
								p.getId());
						request.setAttribute("chosen_program", p);
						out.println("You have chosen the " + p.getName()
								+ " program.");
						// Employee e = dao.getEmployee(u.getUserId());
						session.setAttribute("current_user", e);
						session.setAttribute("chosen_program", e.getProgram());
						request.getRequestDispatcher("employee_program.jsp")
								.forward(request, response);

					}
				}
			} else {
				request.getRequestDispatcher("employee_program_failure.jsp")
						.forward(request, response);
			}
		}

	}

}
