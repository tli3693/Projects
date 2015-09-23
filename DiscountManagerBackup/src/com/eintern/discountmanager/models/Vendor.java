package com.eintern.discountmanager.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "vendors")
public class Vendor extends User {

	@Column
	private String vendor_name;

	@ManyToOne(fetch=FetchType.EAGER)
	private Program program;

	@OneToMany(cascade = { CascadeType.ALL }, fetch =FetchType.EAGER)
	private Set<Discount> discounts;

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Set<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}

	public String getName() {
		return vendor_name;
	}

	public void setName(String name) {
		this.vendor_name = name;
	}

	public void addDiscountToVendor(Discount d) {
		discounts.add(d);
		d.setVendor(this);
		this.discounts.add(d);
	}

	public void removeDiscountToVendor(Discount d) {
		this.discounts.remove(d);
		d.setVendor(null);
		this.discounts.remove(d);
	}
}