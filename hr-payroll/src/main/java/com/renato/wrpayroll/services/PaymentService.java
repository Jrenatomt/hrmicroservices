package com.renato.wrpayroll.services;

import org.springframework.stereotype.Service;

import com.renato.wrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, int days) {
		return new Payment("bob", 200.0, days);
	}
	
}
