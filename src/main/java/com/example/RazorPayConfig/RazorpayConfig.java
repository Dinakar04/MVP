package com.example.RazorPayConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Configuration
public class RazorpayConfig {
	
	 @Value("${razorpay.api.key}")
	    private String apiKey;

	    
	    @Value("${razorpay.api.secret}")
	    private String apiSecret;

	    
	    public String getApiKey() {
	        return apiKey;
	    }

	    
	    public String getApiSecret() {
	        return apiSecret;
	    }
	    
	    @Bean
	    public RazorpayClient razorpayClient() throws RazorpayException {
	        return new RazorpayClient(apiKey, apiSecret);
	    }

	

}
