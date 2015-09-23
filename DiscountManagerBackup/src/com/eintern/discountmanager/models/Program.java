package com.eintern.discountmanager.models;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "programs")
@GenericGenerator(strategy = "increment", name = "programInc")
public class Program {

	@Id
	@GeneratedValue(generator = "programInc")
	@Column(name = "program_id")
	private int id;

	@Column
	private String name;

	@Column
	private int reqMonths;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="Program_Vendor_Id")
	private Set<Vendor> vendors;

	@OneToMany
	private Set<Employee> employees;

	public void addEmployee(Employee e) {
		this.employees.add(e);
	}

	public void removeEmployee(Employee e) {
		this.employees.remove(e);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public int getVendorId() {
		return id;
	}

	public void setVendorId(int vendorId) {
		this.id = vendorId;
	}

	public void addVendorToProgram(Vendor v) {
		this.vendors.add(v);
	}

	public void removeVendorToProgram(Vendor v) {
		this.vendors.remove(v);
	}

	public int getReqMonths() {
		return reqMonths;
	}

	public void setReqMonths(int reqMonths) {
		this.reqMonths = reqMonths;
	}

}
