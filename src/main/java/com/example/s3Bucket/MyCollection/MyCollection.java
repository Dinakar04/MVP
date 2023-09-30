package com.example.s3Bucket.MyCollection;

import java.util.List;

import com.example.s3Bucket.File.FileMetadata;
import com.example.s3Bucket.User.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class MyCollection {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToOne
	private Customer customer;

	
	
	@ManyToMany
	private List<FileMetadata> fileMetadata;
	 
	
	
	  
	public Customer getCustomer() {
		return customer;
	}

	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public long getId() {
		return id;
	}
	
	
	


	
	public List<FileMetadata> getFileMetadata() {
		return fileMetadata;
	}
	

	public void setFileMetadata(List<FileMetadata> fileMetadata) {
		this.fileMetadata = fileMetadata;
	}



	public MyCollection(Customer customer, List<FileMetadata> fileMetadata) {
		super();
		this.customer = customer;
		this.fileMetadata = fileMetadata;
	}


	

	public MyCollection() {
		super();
	}
	
	
	

}
