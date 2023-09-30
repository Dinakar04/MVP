package com.example.s3Bucket.Favorites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.s3Bucket.User.Customer;
import com.example.s3Bucket.Creator.CreatorRepo;
import com.example.s3Bucket.File.FileMetadata;
import com.example.s3Bucket.FileRepo.FileMetaDataRepository;
import com.example.s3Bucket.User.UserRepo;


@Service
public class FavoritesService {
	
	
	
	
	@Autowired
	FavoriteRepo favoriteRepo;
	
	@Autowired
	UserRepo cusertomerRepo;
	
	@Autowired
	FileMetaDataRepository fileMetaRepo;
	
	
	
	
	public boolean addToFav(Long customerId, Long fileId) {
		
		Optional<Customer> customerOptinal = cusertomerRepo.findById(customerId);
		Optional<FileMetadata> fileOptional = fileMetaRepo.findById(fileId);
		
		if(customerOptinal.isEmpty() || fileOptional.isEmpty()) {
			return false;
		}
		
		
		Customer customer = customerOptinal.get();
		FileMetadata fileMetadata = fileOptional.get();
		
		
		
		Favorites favorites;
		
		if(customer.getFavorites() == null) {
			favorites = new Favorites();
			favorites.setCustomer(customer);
		}else {
			favorites = new Favorites();
		}
		
		
		List<FileMetadata> fileMetadatas = favorites.getFileMetadataList();

		
		if(fileMetadatas == null) {
			fileMetadatas = new ArrayList<>();
		}


		fileMetadatas.add(fileMetadata);
		favorites.setFileMetadataList(fileMetadatas);

		
		favoriteRepo.save(favorites);
		
		return true;
	}
	
	
	
	
	public List<FileMetadata> getFavItems(Long customerId){
		Optional<Customer> customerOptional = cusertomerRepo.findById(customerId);
		
		if(customerOptional.isEmpty()) {
			return Collections.emptyList();
		}
		
		Customer customer = customerOptional.get();
		Favorites favorites = customer.getFavorites();
		
		if(favorites == null || favorites.getFileMetadataList() == null || favorites.getFileMetadataList().isEmpty()) {
			return Collections.emptyList();
		}
		
		return favorites.getFileMetadataList();
	}
	
	
	
	
	public boolean removeFavItems(Long customerId, Long fileMetaId) {
		Optional<Customer> customerOptional = cusertomerRepo.findById(customerId);
		
		if(customerOptional.isEmpty()) {
			return false;
		}
		
		Customer customer = customerOptional.get();
		Favorites favorites = customer.getFavorites();
		
		if(favorites == null || favorites.getFileMetadataList() == null || favorites.getFileMetadataList().isEmpty()) {
			return false;
		}
			
		List<FileMetadata> favItems = favorites.getFileMetadataList();
		
		favItems.removeIf(filemeta -> filemeta.getId().equals(fileMetaId));
		
		favoriteRepo.save(favorites);
		
		return true;
	}

	
	public String deleteAllFav() {
		favoriteRepo.deleteAll();
		return "favorites deleted";
	}




	
	
}
