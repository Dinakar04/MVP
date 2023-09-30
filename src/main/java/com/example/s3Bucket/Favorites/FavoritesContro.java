package com.example.s3Bucket.Favorites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s3Bucket.File.FileMetadata;

@RestController
@RequestMapping("/api/v1/fav")
public class FavoritesContro {
	
	
	@Autowired
	FavoritesService favService;
	
	
	
	@PostMapping("/add/fav/{customerId}/{filemetaId}")
	public ResponseEntity<String> addToFav(@PathVariable Long customerId, @PathVariable Long filemetaId){
		
		boolean addedToFav = favService.addToFav(customerId, filemetaId);
		
		if(addedToFav) {
			return ResponseEntity.ok("product to added to MyCollection successfully");
		}else {
			return ResponseEntity.badRequest().body("inavlid customer or product");
		}
	}
	

	@GetMapping("/items/fav/{customerId}")
	public ResponseEntity<List<FileMetadata>> getFavItems(@PathVariable Long customerId){
		List<FileMetadata> favItems = favService.getFavItems(customerId);
		
		if(favItems.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(favItems);
		}
		
		
		
	}
	
	
	@DeleteMapping("/remove/{customerId}/{fileMetaId}")
	public ResponseEntity<String> removeFavItems(@PathVariable Long customerId, @PathVariable Long fileMetaId){
		boolean removed = favService.removeFavItems(customerId, fileMetaId);
		
		if(removed) {
			return ResponseEntity.ok("items are removed from fav succesfully");
		}else {
			return ResponseEntity.badRequest().body("invalid customer or product");
		}
	}
	
	@DeleteMapping("/delete/fav/all")
	public String deleteFav() {
		return favService.deleteAllFav();
	}
	
}
