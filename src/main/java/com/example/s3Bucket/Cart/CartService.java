package com.example.s3Bucket.Cart;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.postgresql.jdbc.FieldMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.s3Bucket.File.FileMetadata;
import com.example.s3Bucket.FileRepo.FileMetaDataRepository;
import com.example.s3Bucket.User.Customer;
import com.example.s3Bucket.User.UserRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CartService {
    
    @Autowired
    CartRepo cartRepo;
//    
    @Autowired
    UserRepo customerRepo;
    
    @Autowired
    FileMetaDataRepository fileMetaRepo;
//

    
//    public List<Cart> getCartList(){
//        return cartRepo.findAll();
//    }

//    
//    public Cart createCart(Cart cart){
//        return cartRepo.save(cart);
//    }

    
    // try cart but works
    
//    public ResponseEntity<String> addToCart(Integer customerId, Long productId) {
//        Optional<Customer> customerOptional = customerRepo.findById(customerId);
//        Optional<FileMetadata> fileOptional = fileMetaRepo.findById(productId);
//        
//        if (customerOptional.isEmpty() || fileOptional.isEmpty()) {
//            return ResponseEntity.badRequest().body("Invalid customer or product.");
//        }
//        
//        Customer customer = customerOptional.get();
//        Product product = productOptional.get();
//        FileMetadata fileMetadata = fileOptional.get();
//        
//        Cart cart;
//        if (customer.getCart() == null) {
//            cart = new Cart();
//            cart.setCustomer(customer);
//        } else {
//            cart = customer.getCart();
//        }
//        
//        List<FileMetadata> fileMetadatas = cart.getFileMetadata();
//        if (fileMetadatas == null) {
//        	fileMetadatas = new ArrayList<>();
//        }
//        fileMetadatas.add(fileMetadata);
//        cart.setFileMetadata(fileMetadatas);
//        
//        cartRepo.save(cart);
//        
//        return ResponseEntity.ok("Product added to cart successfully.");
//    }
//    
    
//    
//    public void addTocart(Integer customerId, Long filemetadataId) {
//    	Customer customer = customerRepo.findById(customerId)
//    			.orElseThrow(() -> new EntityNotFoundException("customer will not found"));
//    			
//    	Product product = productRepo.findById(productId)
//    	FileMetadata fileMetadata = fileMetaRepo.findById(filemetadataId)
//    			.orElseThrow(() -> new EntityNotFoundException("product not found"));
//    	
//    	Cart cartItem = cartRepo.6(customer, fileMetadata);
//    	
//    	cartRepo.save(cartItem);
    	
//    }

//    
//    public List<Cart> getCartItems(Integer customerId){
//    	Customer customer = customerRepo.findById(customerId)
//    			.orElseThrow(() -> new EntityNotFoundException("customer not found"));
//    	
//    	return cartRepo.findByCustomer(customer);
//    }
//
//    

    
    
    // final try
    public boolean addToCart(Long customerId, Long filemetaId) {
        Optional<Customer> customerOptional = customerRepo.findById(customerId);
        Optional<FileMetadata> fileOptional = fileMetaRepo.findById(filemetaId);
        
        if (customerOptional.isEmpty() || fileOptional.isEmpty()) {
            return false;
        }
        
        Customer customer = customerOptional.get();
      //  Product product = productOptional.get();
        FileMetadata fileMetadata  = fileOptional.get();
        
        
        
        Cart cart;
        if (customer.getCart() == null) {
            cart = new Cart();
            cart.setCustomer(customer);
        } else {
            cart = customer.getCart();
        }
        
        
        List<FileMetadata> fileMetadatas = cart.getFileMetadata();
        
        if (fileMetadatas == null) {
        	fileMetadatas = new ArrayList<>();
        }
        
        
        fileMetadatas.add(fileMetadata);
        cart.setFileMetadata(fileMetadatas);
        
        cartRepo.save(cart);
        
        return true;
        
    }
 
//    
//    public List<FileMetadata> getCartItems(Long customerId) {
//        Optional<Customer> customerOptional = customerRepo.findById(customerId);
//        
//        if (customerOptional.isEmpty()) {
//            return Collections.emptyList();
//        }
//        
//        Customer customer = customerOptional.get();
//        Cart cart = customer.getCart();
//        
//        if (cart == null || cart.getFileMetadata() == null || cart.getFileMetadata().isEmpty()) {
//            return Collections.emptyList();
//        }
//        
//        return cart.getFileMetadata();
//    }
    
    
    
    

    
    public boolean removeCartItem(Long customerId, Long fileMetaId) {
        Optional<Customer> customerOptional = customerRepo.findById(customerId);
        
        if (customerOptional.isEmpty()) {
            return false;
        }
        
        Customer customer = customerOptional.get();
        Cart cart = customer.getCart();
        
        if (cart == null || cart.getFileMetadata() == null || cart.getFileMetadata().isEmpty()) {
            return false;
        }
        
        List<FileMetadata> cartItems = cart.getFileMetadata();
        
        cartItems.removeIf(filemeta -> filemeta.getId().equals(fileMetaId));
        
        cartRepo.save(cart);
        
        return true;
    }




	public List<FileMetadata> getCartItems(Long customerId) {
		
		Optional<Customer> customerOptional = customerRepo.findById(customerId);
		
		if(customerOptional.isEmpty()) {
			return Collections.emptyList();
		}
		
		Customer customer = customerOptional.get();
		Cart cart = customer.getCart();
		
		if(cart == null || cart.getFileMetadata() == null || cart.getFileMetadata().isEmpty()) {
			return Collections.emptyList();
		}
		
		
		return cart.getFileMetadata();
	}


}
