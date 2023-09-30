package com.example.s3Bucket.Creator;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CreatorService {

	
	@Autowired
	CreatorRepo creatorRepo;
	
	
	public List<CreatorDev> getAll(){
		return creatorRepo.findAll();
	}
	
	
	
	public CreatorDev newCreator(CreatorDev creator) {
		return creatorRepo.save(creator);
	}

	
	
	
	public Optional<CreatorDev> getCreator(Long creatorId) {
		return creatorRepo.findById(creatorId);
	}
	
	
	
	public String deleteUser(Long creatorId) {
		creatorRepo.deleteById(creatorId);
		return "user deleted succesfully";
	}
	

	
	public String registCreator( String firstName, String lastName, 
			String userName, String email, String passWord, 
			String skillLevel,List<String> interests,List<String> platformsUsing,
			List<String> DevelopingSkill,
			List<String> vrDevices) throws IOException {
		
		CreatorDev creator = new CreatorDev();
		//creator.setProfilePic(getbyteFromFile(file));
		creator.setFirstName(firstName);
		creator.setLastName(lastName);
		creator.setUserName(userName);
		creator.setEmail(email);
		creator.setPassWord(passWord);
		creator.setSkillLevel(skillLevel);
		creator.setInterests(interests);
		creator.setPlatformsUsing(platformsUsing);
		creator.setVrDevices(vrDevices);
		
		creatorRepo.save(creator);
		
		return "creator signed up";
	}


	
	public static byte[] getbyteFromFile(MultipartFile file) throws IOException {
		return file.getBytes();
	}
	

}
