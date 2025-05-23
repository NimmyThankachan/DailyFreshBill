package com.training.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

}