package com.example.s3Bucket.Cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.s3Bucket.File.FileMetadata;
import com.example.s3Bucket.User.Customer;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long>{

	
//	Cart findByCustomerAndProduct(Customer customer, FileMetadata fileMetadata);

//	Cart findByCustomerAndFileMetadata(Customer customer, FileMetadata fileMetadata);
//
//	List<Cart> findByCustomer(Customer customer);
	
//	Cart findByCustomerAndProduct(Customer customer, FileMetadata fileMetadata);
  
}
