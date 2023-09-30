package com.example.Razorpay;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.RazorPayConfig.RazorpayConfig;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@Service
public class RazorPayService {

	
	@Autowired
	RazorpayClient razorpayClient;
	
	@Autowired
	RazorpayConfig razorpayConfig;

    @Value("${razorpay.api.key}")
    private String razorpayKey;

    @Value("${razorpay.api.secret}")
    private String razorpaySecret;
    
    
    public String createOrder(double amount) throws RazorpayException {
		String orderId = "not assigned";

		RazorpayClient razorpay = new RazorpayClient(razorpayKey, razorpaySecret );
		try {
			
		  JSONObject orderRequest = new JSONObject();
		  orderRequest.put("amount", amount*100); // amount in the paise
		  orderRequest.put("currency", "INR");
		  orderRequest.put("receipt", "order_rcptid_11");

		  Order order = razorpay.orders.create(orderRequest);
		  
		  orderId = order.get("id");
		 
		} 
		
		catch (RazorpayException e) {
		  // Handle Exception 
		  System.out.println(e.getMessage());
		}
//    }
		return orderId;

	}
    
    
    
	
}
