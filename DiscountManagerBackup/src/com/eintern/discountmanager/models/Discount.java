package com.eintern.discountmanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "discounts")
@GenericGenerator(strategy = "increment", name = "discountInc")
public class Discount {

	@Id
	@Column(name = "discount_id")
	@GeneratedValue(generator = "discountInc")
	private int id;

	@Column
	private String name;
	private int percent;

	@ManyToOne(fetch = FetchType.EAGER)
	private Vendor vendor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
