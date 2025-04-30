package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.model.Bill;
import com.training.model.Customer;
import com.training.service.BillService;

@RestController
@RequestMapping(value = "/api")
public class BillController {

	@Autowired
	BillService service;

	@Autowired
	RestTemplate template;

	@PostMapping(value = "/add")
	public ResponseEntity<Bill> f1(@RequestBody Bill bill) {
		Bill bill1 = this.service.addNewBill(bill);
		String url = "http://localhost:9121/api/showAll";
		int result = template.getForObject(url, null, Customer.class);
		return new ResponseEntity<>(bill1, HttpStatus.CREATED);
	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<Bill> f4() {
		List<Bill> bills = this.service.getAllBills();
		return new ResponseEntity(bills, HttpStatus.OK);
	}

}
