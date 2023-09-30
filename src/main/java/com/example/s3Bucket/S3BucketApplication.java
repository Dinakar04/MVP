package com.example.s3Bucket;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com")
@EntityScan
public class S3BucketApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3BucketApplication.class, args);
	}
	
}

