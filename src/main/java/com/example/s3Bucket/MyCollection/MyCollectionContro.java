package com.example.s3Bucket.MyCollection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s3Bucket.File.FileMetadata;

@RestController
@RequestMapping("/api/v1/purchased")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyCollectionContro {
	
	@Autowired
	MyCollectionService collectionService;
	
	
	@PostMapping("/downloadable/add/{customerId}/{filemetaId}")
	public ResponseEntity<String> addToCollection(@PathVariable Long customerId, @PathVariable Long filemetaId){
		
		boolean addedToCollection = collectionService.addToCollection(customerId, filemetaId);
		
		if(addedToCollection) {
			return ResponseEntity.ok("product added and ready to download");
		} else {
			return ResponseEntity.badRequest().body("invalid customer or product ");
		}
	}
	
	
	@GetMapping("/items/downloadable/{customerId}")
	public ResponseEntity<List<FileMetadata>> getCollectionItems(@PathVariable Long customerId){
		
		List<FileMetadata> downloadable = collectionService.getCollectionItem(customerId);
		
		if(downloadable.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
            return ResponseEntity.ok(downloadable);
        }
		
	}
	
	
	
	@DeleteMapping("/remove/downloadable/{customerId}/{fileMetaId}")
	public ResponseEntity<String> removeCollection(@PathVariable Long customerId, @PathVariable Long fileMetaId )
	{
		boolean removed = collectionService.removeCollection(customerId, fileMetaId);
		
		if(removed) {
			return ResponseEntity.ok("Collection item removed succesfully");
		}else {
			return ResponseEntity.badRequest().body("invalid customer or product");
		}
	}
	
	
	
	

}
