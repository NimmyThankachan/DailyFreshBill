package com.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bill_items")
public class BillItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "bill_id", nullable = false)
	private Bill bill;

	@Column(name = "item_name")
	private String itemName;

	private int quantity;
	private double price;

	public String getItemName() {
		return itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}
}
