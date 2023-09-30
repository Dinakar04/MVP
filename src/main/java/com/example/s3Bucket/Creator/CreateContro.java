package com.example.s3Bucket.Creator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/creator")
public class CreateContro {

	
	
	
	@Autowired
	CreatorService creatorService;
	

	
	@Autowired
	CreatorRepo creatorRepo;


	
	
	@PostMapping("/signup/creator")
	public ResponseEntity<String> signupCreator( @RequestParam("firstName") String firstName,
			 @RequestParam("lastName") String lastName,
			 @RequestParam("userName") String userName,
			 @RequestParam("email") String email,
			 @RequestParam("passWord") String passWord,
			 //@RequestParam("profilePic") MultipartFile profilePic,
			 @RequestParam("contactNo") String contactNo,
			 @RequestParam("skillLevel") String skillLevel ,
			 @RequestParam("interests") List<String> interests,
			 @RequestParam("platformsUsing")List<String>platformsUsing,
			 @RequestParam("DevelopingSkill")List<String> DevelopingSkill,
			 @RequestParam("vrDevices")List<String> vrDevices){ 
		
		try {
			CreatorDev creator = creatorRepo.findByEmail(email);
			
			if(creator != null) {
				return ResponseEntity.badRequest().body("Creator already exist with this eamil id");		
			}else {
			creatorService.registCreator( firstName, lastName, userName, email, passWord, skillLevel, interests, platformsUsing, DevelopingSkill, vrDevices);
			}
			return ResponseEntity.ok("Creator registered succesfully");
		}catch(Exception e){
			 return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to SignUP: " + e.getMessage());
		}
		
		
	}
	
	
	
	
	@GetMapping("/login/creator")
	public ResponseEntity<CreatorDev> loginCreator(@RequestParam String email, @RequestParam String passWord){
		CreatorDev creator = creatorRepo.findByEmail(email);
		
		if(creator != null && creator.getPassWord().equals(passWord)) {
			return ResponseEntity.ok(creator);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
	}
	

	
//	@GetMapping("/get/all")
//	public List<CreatorDev> allUser(){
//		return creatorService.getAll();
//	}
	
	
	
}
