package com.example.s3Bucket.Favorites;

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
public class Favorites {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private  Customer customer;
	
	@ManyToMany
	private List<FileMetadata> fileMetadataList;


	public long getId() {
		return id;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	public List<FileMetadata> getFileMetadataList() {
		return fileMetadataList;
	}

	
	
	public void setFileMetadataList(List<FileMetadata> fileMetadataList) {
		this.fileMetadataList = fileMetadataList;
	}
	
	
	
	public Favorites(Customer customer, List<FileMetadata> fileMetadataList) {
		super();
		this.customer = customer;
		this.fileMetadataList = fileMetadataList;
	}


	
	public Favorites() {
		
	}


}
