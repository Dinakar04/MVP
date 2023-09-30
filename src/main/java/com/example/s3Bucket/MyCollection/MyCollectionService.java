package com.example.s3Bucket.MyCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.s3Bucket.File.FileMetadata;
import com.example.s3Bucket.FileRepo.FileMetaDataRepository;
import com.example.s3Bucket.User.Customer;
import com.example.s3Bucket.User.UserRepo;

@Service
public class MyCollectionService {
	
	
	
	@Autowired
	MyCollectionRepo collectionRepo;
	
	@Autowired
	UserRepo customerRepo;
	
	@Autowired
    FileMetaDataRepository fileMetaRepo;
	
	
	
	public List<MyCollection> getCollectionList(){
		return collectionRepo.findAll();
	}
	
	
	
	
	public MyCollection createCollection(MyCollection collection) {
		return collectionRepo.save(collection);
	}

	
	
	public boolean addToCollection(Long customerId, Long fileMetaId) {
		Optional<Customer> customerOptional = customerRepo.findById(customerId);
		Optional<FileMetadata> fileOptional = fileMetaRepo.findById(fileMetaId);
		
		if(customerOptional.isEmpty() || fileOptional.isEmpty()) {
			return false;
		}
		
		Customer customer = customerOptional.get();
		FileMetadata filemeta = fileOptional.get();
		
		
		
		MyCollection collection;
		if(customer.getCollection() == null) {
			collection = new MyCollection();
			collection.setCustomer(customer);
		} else {
		 	collection = customer.getCollection();
		}
		
		List<FileMetadata> fileMetaList = collection.getFileMetadata();
		
		if(fileMetaList == null) {
			fileMetaList = new ArrayList<>();
			
		}
		
		
		fileMetaList.add(filemeta);
		collection.setFileMetadata(fileMetaList);
		
		collectionRepo.save(collection);
		
		return true;
	}
	
	
	
	
	public boolean removeCollection(Long customerId, Long fileMetaID) {
		Optional<Customer> customerOptional = customerRepo.findById(customerId);
		
		if(customerOptional.isEmpty()) {
			return false;
		}
		
		Customer customer = customerOptional.get();
		MyCollection collection = customer.getCollection();
		
		if(collection == null || collection.getFileMetadata() == null || collection.getFileMetadata().isEmpty()) {
			return false;
		}
		
		List<FileMetadata> collectionItems = collection.getFileMetadata();
		
		collectionItems.removeIf(fileMeta -> fileMeta.getId().equals(fileMetaID));
		
		collectionRepo.save(collection);
		
		return true;
	}
	
	
	public List<FileMetadata> getCollectionItem(Long customerId){
		Optional<Customer> customerOptional = customerRepo.findById(customerId);
		
		
		if(customerOptional.isEmpty()) {
			return Collections.emptyList();
		}
		
		Customer customer = customerOptional.get();
		MyCollection collection = customer.getCollection();
		
		if(collection == null || collection.getFileMetadata() == null || collection.getFileMetadata().isEmpty()) {
			return Collections.emptyList();
		}
		
		return collection.getFileMetadata();		
		
	}
	
	
}
