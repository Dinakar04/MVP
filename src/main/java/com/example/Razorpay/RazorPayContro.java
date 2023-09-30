package com.example.Razorpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.razorpay.RazorpayException;

@RestController
public class RazorPayContro {

	
	@Autowired
	RazorPayService razorPayService;	
	
	
	@PostMapping("/createOrder")
	public String createOrder(@RequestParam double amount) throws RazorpayException {
		return razorPayService.createOrder(amount);
	}
}
