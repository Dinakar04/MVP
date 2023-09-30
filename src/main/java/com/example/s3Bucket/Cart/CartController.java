package com.example.s3Bucket.Cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.s3Bucket.File.FileMetadata;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {
	
//	
	@Autowired
	CartService cartService;

	@Autowired
	CartRepo cartrepo;
//	
//	@PostMapping("/add")
//	 public void addToCart(@RequestParam Integer userId, @RequestParam Long fileMetadataId) {
//		cartService.addTocart(userId, fileMetadataId);
//	}
//
//	
//	
//	
//	@GetMapping("/items/{customerId}")
//	public List<Cart> getCartItems(@PathVariable Integer customerId){
//		return cartService.getCartItems(customerId);
//	}
//
//	
//	
//	
//	@DeleteMapping("/remove/{cartItemId}")
//    public void removeCartItem(@PathVariable Integer cartItemId) {
//        cartService.removeCartItem(cartItemId);
//    }
	
	
	@PostMapping("/add/{customerId}/{filemetaId}")
	public ResponseEntity<String> addToCart(@PathVariable Long customerId,
			@PathVariable Long filemetaId){
		boolean addedTocart = cartService.addToCart(customerId, filemetaId);
		
		if(addedTocart) {
			return ResponseEntity.ok("product added to cart successfully");
		}else {
			return ResponseEntity.badRequest().body("invalid customer or product");
		}
		
	}
	
	

	@GetMapping("/items/{customerId}")
    public ResponseEntity<List<FileMetadata>> getCartItems(@PathVariable Long customerId) {
        List<FileMetadata> cartItems = cartService.getCartItems(customerId);
        
        if (cartItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(cartItems);
        }
    }
	
	
	@DeleteMapping("/remove/{customerId}/{fileMetaId}")
    public ResponseEntity<String> removeCartItem(@PathVariable Long customerId, @PathVariable Long fileMetaId) {
        boolean removed = cartService.removeCartItem(customerId, fileMetaId);
        
        if (removed) {
            return ResponseEntity.ok("Cart item removed successfully.");
        } else {
            return ResponseEntity.badRequest().body("Invalid customer or product.");
        }
    }
	
	@DeleteMapping("/delete/cart")
	public String deleteCart() {
	
		cartrepo.deleteAll();
		return "cart deleted";
	}
	
	

}
