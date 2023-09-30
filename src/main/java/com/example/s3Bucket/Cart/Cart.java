package com.example.s3Bucket.Cart;

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
public class Cart {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    private Customer customer;

    
//    @ManyToOne
//    private FileMetadata fileMetadata;

    
    @ManyToMany
    private List<FileMetadata> fileMetadatas;
    

    
    //getters AND setters
    public Customer getCustomer() {
		return customer;
	}
 

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    
//    public FileMetadata getFileMetadata() {
//        return fileMetadata;
//    }



//    public void setFileMetadata(FileMetadata fileMetadata) {
//        this.fileMetadata = fileMetadata;
//    }


//    public Cart(Customer customer, FileMetadata fileMetadata) {
//		super();
//		this.customer = customer;
//		this.fileMetadata = fileMetadata;
//	}


	public Cart() {
    }


	public List<FileMetadata> getFileMetadata() {
		return fileMetadatas;
	}


	
	public void setFileMetadata(List<FileMetadata> fileMetadata) {
		this.fileMetadatas = fileMetadata;
	}


	public Cart(Customer customer, List<FileMetadata> fileMetadatas) {
		super();
		this.customer = customer;
		this.fileMetadatas = fileMetadatas;
	}

    
}
