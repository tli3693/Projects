package com.eintern.discountmanager.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class SalesTeam extends User {

	public Program makeProgram(String name, int numMonths, Set<Vendor> vendors) {
		Program program = new Program();

		for (Vendor v : vendors) {
			program.addVendorToProgram(v);
		}

		program.setReqMonths(numMonths);
		return program;

	}

	public Program editProgram(String name, Set<Vendor> vendors) {
		Program program = new Program();

		for (Vendor v : vendors) {
			program.removeVendorToProgram(v);
		}

		return program;
	}
}
