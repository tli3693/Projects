package com.eintern.discountmanager.models.delegate;

import java.util.List;
import java.util.Set;

import com.eintern.discountmanager.DAO.DiscountManagerDAO;
import com.eintern.discountmanager.models.*;

public class DiscountDelegate {
	private static final DiscountManagerDAO dao = new DiscountManagerDAO();

	public Vendor createDiscount(Vendor v, String dName, int dPercent) {

		Vendor v1 = null;
		try {
			Discount d = dao.getDiscountWithName(dName);
			if (d == null)
				d = new Discount();
			d.setName(dName);
			d.setPercent(dPercent);

			dao.saveObject(d);
			dao.addDiscount(d.getId(), v.getUserId());
			v1 = (Vendor) dao.getVendor(v.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v1;
	}

	public Program createProgram(String name, String[] vendors) {
		Program p = new Program();
		p.setName(name);

		dao.saveObject(p);
		p = dao.getProgramByName(name);
		Vendor v = null;
		for (int i = 0; i < vendors.length; i++) {
			System.out.println(vendors[i]);
			v = dao.getVendorByName(vendors[i]);
			dao.addVendor(v.getUserId(), p.getId());
		}
		return p;
	}

	public List<Program> getAllPrograms() {
		return dao.getPrograms();
	}

	public List<Employee> getAllEmployees() {
		return dao.getEmployees();
	}

	public List<Vendor> getAllVendors() {
		return dao.getVendors();
	}

	public Employee enrollInProgram(int employeeId, int programId) {
		dao.enrollInProgram(employeeId, programId);
		return dao.getEmployee(employeeId);
	}

	public int checkLoginCredentials(String username, String password) {
		if (dao.checkUserPassword(username, password)) {
			System.out.println("Username password is correct!");

			switch (dao.checkRole(username)) {
			case 0:
				return 0;
			case 1:
				return 1;

			case 2:
				return 2;

			case 3:
				return 3;

			}
		}
		return 0;
	}

	public User getUser(String username) {
		int id = dao.getUserId(username);
		return dao.getUser(id);
	}

	public User registerNewUser(String username, String password, String email,
			String role, String fname, String lname) {
		if (dao.userExists(username)) {
			return null;

		} else {
			if (role.equals("emp")) {
				Employee user = new Employee();
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setFirstname(fname);
				user.setLastname(lname);
				dao.saveObject(user);
				return getUser(username);

			} else if (role.equals("sales")) {
				SalesTeam user = new SalesTeam();
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setFirstname(fname);
				user.setLastname(lname);
				dao.saveObject(user);
				return getUser(username);
			}
		}
		return null;

	}

	public Vendor registerNewUser(String username, String password,
			String email, String role, String fname, String lname,
			String vendor_name) {
		Vendor user = new Vendor();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstname(fname);
		user.setLastname(lname);
		user.setName(vendor_name);
		dao.saveObject(user);
		return user;
	}

	public boolean removeDiscount(Set<Discount> discounts, Vendor v, String disc) {
		for (Discount d : discounts) {
			if (disc.equals(d.getName())) {
				dao.removeDiscount(d.getId(), v.getUserId());
				return true;
			}
		}
		return false;
	}

	public boolean removeProgram(List<Program> programs, String program) {
		for (Program p : programs) {
			if (p.getName().equals(program)) {
				dao.remObject(p);
				return true;
			}
		}
		return false;
	}

	public Employee unenrollInProgram(Employee u) {
		List<Program> list = getAllPrograms();

		if (u.getProgram() != null) {
			for (Program pro : list) {
				if (u.getProgram().getName().equals(pro.getName())) {
					dao.unEnrollInProgram(u.getUserId(), pro.getId());
					return dao.getEmployee(u.getUserId());
				}
			}
		}
		return null;
	}

	public User updateUser(User user, String email, String fname, String lname) {

		dao.updateUser(user, email, fname, lname);
		return getUser(user.getUsername());
	}

	public User updateUser(User user, String email, String fname, String lname,
			String pwd, String pwd2) {
		if (pwd != null && pwd2 != null) {
			if (pwd.equals(pwd2)) {
				dao.updateUser(user, email, fname, lname, pwd, pwd2);
			}
		}
		return getUser(user.getUsername());
	}

	public Program getProgramByName(String program) {
		List<Program> list = getAllPrograms();
		for (Program p : list) {
			if (program.equals(p.getName()))
				return p;
		}
		return null;
	}

	public Vendor editDiscount(int vendorId, int discountId) {
		return null;

	}

	public boolean removeFromProgram(String username) {
		Employee e = (Employee) getUser(username);
		if (e.getProgram() != null) {
			dao.unEnrollInProgram(e.getUserId(), e.getProgram().getId());
			return true;
		}
		return false;
	}
}