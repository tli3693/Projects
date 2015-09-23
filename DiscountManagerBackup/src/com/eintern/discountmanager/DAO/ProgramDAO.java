package com.eintern.discountmanager.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProgramDAO {
	public static Session getSession() {

		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		return factory.openSession();

	}
	
}
