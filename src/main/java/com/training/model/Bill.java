package com.training.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "bill_date")
	private Date billDate;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BillItem> billItems;

	@Column(name = "total_amount")
	private double totalAmount;

	// Utility Methods
	private double calculateTotalAmount() {
		return billItems.stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
	}

	private int calculateRewardPoints() {
		return (int) (totalAmount / 10); // Example: 1 point per ₹10 spent
	}

	public double getTotalAmount() {
		return totalAmount;
	}

}