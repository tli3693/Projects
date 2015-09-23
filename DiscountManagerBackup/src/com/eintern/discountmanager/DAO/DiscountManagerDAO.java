package com.eintern.discountmanager.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.eintern.discountmanager.models.Discount;
import com.eintern.discountmanager.models.Employee;
import com.eintern.discountmanager.models.Program;
import com.eintern.discountmanager.models.User;
import com.eintern.discountmanager.models.Vendor;

public class DiscountManagerDAO {

	public Session getSession() {

		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		return factory.openSession();

	}

	// create
	public void saveObject(Object obj) {

		Session session = getSession();
		Transaction trans = session.getTransaction();

		try {
			trans.begin();
			session.saveOrUpdate(obj);
			trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}

	}

	public void updateUser(User obj, String email, String fname, String lname) {

		Session session = getSession();
		Transaction trans = session.getTransaction();
		try {
			trans.begin();
			User user = (User) session.get(User.class, obj.getUserId());
			if (user == null)
				throw new HibernateException("User not found!");
			user.setEmail(email);
			user.setFirstname(fname);
			user.setLastname(lname);
			session.update(user);
			trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}

	}

	public void updateUser(User obj, String email, String fname, String lname,
			String pwd, String pwd2) {

		Session session = getSession();
		Transaction trans = session.getTransaction();
		try {
			trans.begin();
			User user = (User) session.get(User.class, obj.getUserId());
			if (user == null)
				throw new HibernateException("User not found!");
			user.setEmail(email);
			user.setFirstname(fname);
			user.setLastname(lname);
			user.setEmail(email);
			user.setFirstname(fname);
			user.setLastname(lname);
			user.setPassword(pwd);

			session.update(user);
			trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}

	}

	public void removeProgram(int programId) {
		Session session = getSession();
		Transaction trans = session.getTransaction();

		try {
			trans.begin();

			Program p = (Program) session.get(Program.class, programId);

			if (p == null)
				throw new HibernateException("Program not found!");

			session.update(p);

			trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}

	}

	public void addVendor(int vendorId, int programId) {
		Session session = getSession();
		Transaction trans = session.getTransaction();

		try {
			trans.begin();

			Vendor v = (Vendor) session.get(User.class, vendorId);
			Program p = (Program) session.get(Program.class, programId);

			if (v == null)
				throw new HibernateException("Vendor not found!");
			if (p == null)
				throw new HibernateException("Program not found!");

			p.addVendorToProgram(v);

			session.update(v);
			session.update(p);

			trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}

	}

	public void addDiscount(int discountId, int vendorId) {
		Session session = getSession();
		Transaction trans = session.getTransaction();

		try {
			trans.begin();

			Vendor v = (Vendor) session.get(Vendor.class, vendorId);
			Discount d = (Discount) session.get(Discount.class, discountId);

			if (v == null)
				throw new HibernateException("Vendor not found!");
			if (d == null)
				throw new HibernateException("Discount not found!");

			v.addDiscountToVendor(d);

			session.update(d);
			session.update(v);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}

	}

	public void removeDiscount(int discountId, int vendorId) {
		Session session = getSession();
		Transaction trans = session.getTransaction();

		try {
			trans.begin();

			Vendor v = (Vendor) session.get(Vendor.class, vendorId);
			Discount d = (Discount) session.get(Discount.class, discountId);

			if (v == null)
				throw new HibernateException("Vendor not found!");
			if (d == null)
				throw new HibernateException("Discount not found!");

			v.removeDiscountToVendor(d);

			session.delete(d);
			session.update(v);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}

	}

	public void remObject(Object obj) {
		Session session = getSession();
		Transaction trans = session.getTransaction();

		try {
			trans.begin();
			session.delete(obj);
			trans.commit();
			System.out.println("Successfully removed an object!");

		} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();

		} finally {
			session.close();
		}

	}

	// read
	public Program getProgram(int programId) {
		Session session = getSession();

		Program p = null;
		try {
			p = (Program) session.get(Program.class, programId);

			if (p == null)
				throw new HibernateException("Program not found!");

		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		return p;
	}

	public User getVendor(int vendorId) {
		Session session = getSession();
		Vendor v = null;

		try {
			v = (Vendor) session.get(Vendor.class, vendorId);

			if (v == null)
				throw new HibernateException("Vendor not found!");

		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		return v;
	}

	public Employee getEmployee(int employeeId) {
		Session session = getSession();
		Employee e = null;
		try {
			e = (Employee) session.get(Employee.class, employeeId);

			if (e == null)
				throw new HibernateException("Employee not found! ID: "
						+ employeeId);
		} catch (HibernateException ex) {
			ex.printStackTrace();

		} finally {
			session.close();

		}
		return e;
	}

	public User getUser(int userId) {
		Session session = getSession();
		User u = null;
		try {
			u = (User) session.get(User.class, userId);

			if (u == null)
				throw new HibernateException("User not found!");
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		return u;
	}

	public Discount getDiscount(int discountId) {
		Session session = getSession();
		Discount d = null;
		try {
			d = (Discount) session.get(Discount.class, discountId);

			if (d == null)
				throw new HibernateException("Discount not found!");
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		return d;

	}

	public Discount getDiscountWithName(String name) {
		Session session = getSession();

		List<Discount> results = null;
		try {
			Criteria criterion = session.createCriteria(Discount.class);
			criterion.add(Restrictions.like("name", name));

			results = criterion.list();
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		if (results.isEmpty())
			return null;

		Discount d = results.get(0);

		return d;

	}

	public boolean checkUserPassword(String username, String password) {
		Session session = getSession();
		List<User> results = new ArrayList<>();
		try {
			Criteria criterion = session.createCriteria(User.class);
			criterion.add(Restrictions.like("username", username));
			criterion.add(Restrictions.like("password", password));
			results = criterion.list();
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		if (!(results.isEmpty()))
			return true;
		return false;
	}

	public Vendor getVendorByName(String name) {
		Session session = getSession();
		Vendor u = null;
		List<User> results = new ArrayList<>();
		try {
			Criteria criterion = session.createCriteria(User.class);
			criterion.add(Restrictions.like("vendor_name", name));
			results = criterion.list();
			u = (Vendor) results.get(0);
			if (u == null)
				throw new HibernateException("User not found!");

		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		return u;
	}

	public boolean userExists(String username) {
		Session session = getSession();
		List<?> results = null;
		try {
			Criteria criterion = session.createCriteria(User.class);
			criterion.add(Restrictions.like("username", username));
			results = criterion.list();
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		if (!(results.isEmpty()))
			return true;
		return false;
	}

	public int getUserId(String username) {
		Session session = getSession();
		List<?> results = null;
		try {
			Criteria criterion = session.createCriteria(User.class);
			criterion.add(Restrictions.like("username", username));
			results = criterion.list();
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		return ((User) results.get(0)).getUserId();
	}

	// return 0 if not found
	// return 1 if employee
	// return 2 if vendor
	// return 3 if sales
	public int checkRole(String username) {
		Session session = getSession();
		Criteria criterion = session.createCriteria(User.class);
		List<?> results = null;
		String value = null;
		try {
			criterion.add(Restrictions.like("username", username));
			results = criterion.list();

			User user = (User) results.get(0);

			value = user.getDecriminatorValue();
			System.out.println(value);
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		if (value.equals("Employee"))
			return 1;
		if (value.equals("Vendor")) {
			System.out.println("He is a vendor");
			return 2;

		}
		if (value.equals("SalesTeam"))
			return 3;

		return 0;

	}

	public List<Program> getPrograms() {
		Session session = getSession();

		List<Program> list = null;
		try {

			Criteria criterion = session.createCriteria(Program.class);
			criterion.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = criterion.list();

			for (Program p : list) {
				System.out.println("Program ID: " + p.getId());
			}
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}

		if (list.isEmpty())
			return null;

		return list;

	}

	public List<Employee> getEmployees() {
		Session session = getSession();

		List<Employee> list = null;
		try {
			Criteria criterion = session.createCriteria(Employee.class);
			criterion.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = criterion.list();

			for (Employee emp : list) {
				System.out.println("Employee ID: " + emp.getUserId());
			}
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}

		if (list.isEmpty())
			return null;

		return list;

	}

	public int getEmployeeMonths(String username) {

		Session session = getSession();
		List<?> results = null;
		int dur = 0;
		try {
			Criteria criterion = session.createCriteria(User.class);

			criterion.add(Restrictions.like("username", username));
			results = criterion.list();

			Employee user = (Employee) results.get(0);
			dur = user.getEmployeeDuration();
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		return dur;

	}

	public void enrollInProgram(int employeeId, int programId) {
		Session session = getSession();
		Employee e = null;
		Program p = null;
		try {
			session.beginTransaction();
			e = (Employee) session.get(Employee.class, employeeId);
			p = (Program) session.get(Program.class, programId);

			if (e == null)
				throw new HibernateException("Employee not found!");
			if (p == null)
				throw new HibernateException("Program not found!");

			if (e.getProgram() == null) {
				e.setProgram(p);
				p.addEmployee(e);
			} else
				System.out.println("Employee is already in a program!");

			session.update(e);
			session.update(p);
			session.getTransaction().commit();
			System.out.println("Successfully enrolled in a program.");
		} catch (HibernateException ex) {
			ex.printStackTrace();

		} finally {
			session.close();

		}

	}

	public void unEnrollInProgram(int employeeId, int programId) {
		Session session = getSession();
		Employee e = null;
		Program p = null;
		try {
			session.beginTransaction();
			e = (Employee) session.get(Employee.class, employeeId);
			p = (Program) session.get(Program.class, programId);

			if (e == null)
				throw new HibernateException("Employee not found!");
			if (p == null)
				throw new HibernateException("Program not found!");

			e.setProgram(null);
			p.removeEmployee(e);

			session.update(e);
			session.update(p);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();

		} finally {
			session.close();

		}
	}

	public List<Vendor> getVendors() {
		Session session = getSession();
		List<Vendor> list = null;

		try {
			Criteria criterion = session.createCriteria(Vendor.class);
			criterion.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = criterion.list();

			for (Vendor v : list) {
				System.out.println("Employee ID: " + v.getUserId());
			}
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}

		if (list.isEmpty())
			return null;

		return list;
	}

	public Program getProgramByName(String name) {
		Session session = getSession();
		Program u = null;
		List<Program> results = new ArrayList<>();
		try {
			Criteria criterion = session.createCriteria(Program.class);
			criterion.add(Restrictions.like("name", name));
			results = criterion.list();
			u = results.get(0);
			if (u == null)
				throw new HibernateException("User not found!");
			u = results.get(0);
		} catch (HibernateException e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		return u;
	}
}