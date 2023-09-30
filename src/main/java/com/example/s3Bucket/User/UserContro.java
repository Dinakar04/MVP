package com.example.s3Bucket.User;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// import com.example.s3Bucket.Job.Job;
// import com.example.s3Bucket.Job.JobRepo;


@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserContro {
	
	
	@Autowired
	UserService userService;
	
	@Autowired 
	UserRepo userRepo;
	
	// @Autowired
	// JobRepo jobRepo;
//	@PostMapping
//	public Customer creatUser(Customer customer) {
//		return userService.createCustomer(customer);
//	}
	


	@GetMapping
	public List<Customer> getAllCustomer(){
		return userRepo.findAll();
	}
	
	@GetMapping("/user/{userId}")
	public Optional<Customer> getByCustomerId(@PathVariable Long userId) {
		return userRepo.findById(userId);
	}
	
	
	
	
	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Customer customer) {
        if (userService.userExists(customer.getEmail())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        userService.createCustomer(customer);

        return ResponseEntity.ok("User registered successfully");
    }
	

	
//	public ResponseEntity<String> signUp(@RequestParam String firstName, @RequestParam String lastName,
//			@RequestParam String userName, @RequestParam String email, @RequestParam String passWord,
//			@RequestParam MultipartFile profilePic, @RequestParam String contactNo){
//		
//		
//		
//	}
	
	

	
	@PostMapping("/save")
	public Customer saveUser(@RequestBody Customer customer) {
		return userRepo.save(customer);
	}
	

	@PostMapping("/login")
	public boolean loginUser(@RequestParam String email, @RequestParam String password) {
	        Customer existingUser = userService.getUserByEmail(email);

	        if (existingUser != null && existingUser.getPassWord().equals(password)) {
	            return true ;
	        }

	        return false;
	 }
	 
	
	 @PostMapping("/login/customer")
	 public ResponseEntity<Customer> login(@RequestParam String email, @RequestParam String password) {
	     Customer customer = userRepo.findByEmail(email);

	     if (customer != null && customer.getPassWord().equals(password)) {
	         return ResponseEntity.ok(customer);
	     } else {
	         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	     }
	 }

 
	 
	 
	 
	 
	 @PostMapping("/signup/profilePic")
	 public ResponseEntity<String> uploadUserPic(
			 @RequestParam("firstName") String firstName,
			 @RequestParam("lastName") String lastName,
			 @RequestParam("userName") String userName,
			 @RequestParam("email") String email,
			 @RequestParam("passWord") String passWord,
			 @RequestParam("profilePic") String profilePicUrl,
			 @RequestParam("contactNo") String contactNo
			 ){
		 try {
			 
			 userService.uploadUserProfile(firstName, lastName, userName, email, passWord, profilePicUrl,contactNo);
			 return ResponseEntity.ok("User signedUp successfully");
		 } catch(Exception e){
	            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to SignUP: " + e.getMessage());	 
	        } 
	     }

	 

	 
	 

	 @GetMapping("/email")
	 public Customer getByEmail(@RequestParam String email) {
		 return userService.getUserByEmail(email);
	 }
	  
	 


	@PostMapping("/entityDto")
	public UserEntityDTO convertDto(Customer customer) {
		 return userService.convertEntityToDTO(customer);
				 
	 }
	
	
	
	@DeleteMapping("/delete/all")
	public String deleteCustomer() {
		userRepo.deleteAll();
		return "delete all customer";
	}
	
	
//	
//	   @PostMapping("/job/create")
//	    public Job createJob(@RequestBody Job job, @RequestParam Integer userId) {
////	        Optional<Customer> optionalUser = userRepo.findById(userId);
////	        if (optionalUser.isPresent()) {
////	            Customer user = optionalUser.get();
//
//	            Job jobOrg = new Job();
//	            jobOrg.setTitle(job.getTitle());
//	            jobOrg.setDescription(job.getDescription());
//	            jobOrg.setJobFee(job.getJobFee());
////	            jobOrg.setCustomer(user);
//	            jobOrg.setDevType(job.getDevType());
//	            jobOrg.setDurationDays(job.getDurationDays());
//	            jobOrg.setKeyWordsJob(job.getKeyWordsJob());
//
//	            return jobRepo.save(job);
//	        } else {
//	            throw new IllegalArgumentException("User not found with ID: " + userId);
//	        }
//	    }
	   
	   
	   
//	@PatchMapping("/patch/userId")
//	public ResponseEntity<>

}
