package com.example.s3Bucket.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Customer, Long>{
	
	Customer findByEmail(String email);

	Optional<Customer> findById(Long customerId);

	
    
}
