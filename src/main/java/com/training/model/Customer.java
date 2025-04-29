package com.training.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@EqualsAndHashCode.Include
	private int customerId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id", nullable = false)
	private Contact contact;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	
	@Column(name = "reward_points")
    private int rewardPoints;

}
