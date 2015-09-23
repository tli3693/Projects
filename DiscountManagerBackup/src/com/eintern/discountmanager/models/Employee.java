package com.eintern.discountmanager.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "employeess")
public class Employee extends User {

	@Column(length = 25)
	private int employeeDuration;
	
	private static Date startDate;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Employee_Program_Id")
	private Program program;

	public int getEmployeeDuration() {
		return employeeDuration;
	}

	public void setEmployeeDuration(int employeeDuration) {
		this.employeeDuration = employeeDuration;
	}

	public static Date getStartDate() {
		return startDate;
	}

	public static void setStartDate(Date startDate) {
		Employee.startDate = startDate;
	}

	public void enrollInProgram(Program p) {
		this.setProgram(p);
	}

	public void unEnrollInProgram(Program p) {
		this.setProgram(null);
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

}