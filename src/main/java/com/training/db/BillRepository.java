package com.training.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
	List<Bill> findByCustomerId(Long customerId);
}