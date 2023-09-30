package com.example.s3Bucket.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
	
	
	
	@Autowired
	UserRepo userRepo;
	
	
	
	public Customer  createCustomer(Customer customer) {
		return userRepo.save(customer);
	}
	
	
	
	
	
	public List<Customer> getCustomerList(){
		return userRepo.findAll();
	}
	

	
	   public String uploadUserProfile(String firstName, String lastName, String userName, String email, String passWord,String profilePicUrl,String contactNo) throws IOException {
		   Customer customer = new Customer();
		   
		   customer.setFirstName(firstName);
		   customer.setLastName(lastName);
		   customer.setUserName(userName);
		   customer.setEmail(email);
		   customer.setPassWord(passWord);
		   customer.setProfilePic(profilePicUrl);
		   customer.setContactNo(contactNo);
		   customer.setInterests(customer.getInterests());
		   userRepo.save(customer);
		   return "User Registered Successfully";
		   
	   }
	
	   
	   
  
	public Customer getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	
	
	

	public boolean userExists(String email) {
        return userRepo.findByEmail(email) != null;
    }
	
	
	
	
  public UserEntityDTO convertEntityToDTO(Customer customerEntity){

      UserEntityDTO userEntityDTO = new UserEntityDTO();
      
      userEntityDTO.setId(customerEntity.getUserId());
      userEntityDTO.setUserNameDTO(customerEntity.getUserName());
      userEntityDTO.setProfilePicUrl(customerEntity.getProfilePic());
      
//      userEntityDTO.setEmail("santhosh@gmail.com");
//      userEntityDTO.setPassWord("santhosh@6");
//      System.out.println(userEntityDTO.toString());
      return userEntityDTO ;
      
  }


  
  
  
  public  byte[] getBytesFromFile(MultipartFile file) throws IOException {
      return file.getBytes();
   }

  
}
