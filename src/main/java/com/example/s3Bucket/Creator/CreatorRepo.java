package com.example.s3Bucket.Creator;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepo extends JpaRepository<CreatorDev, Long>{

	CreatorDev findByEmail(String email);
	
	

}
