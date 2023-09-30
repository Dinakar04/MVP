package com.example.s3Bucket.User;


public class UserEntityDTO {


    private long id;
    private String userName;
    private String profilePicUrl;

 
    
    
    // constructors
    
	public  UserEntityDTO(long id, String userName, String profilePicUrl){

        this.id = id;
        this.userName = userName;
        this.profilePicUrl=profilePicUrl;
        
    }

	
    public UserEntityDTO() {
    	
    }


    
    
    
    //getters and setters
    
    public long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

 

    public String getName() {
        return userName;
    }
    
    

    public void setName(String userName) {
        this.userName = userName;
    }


	public String getUserName() {
		return userName;
	}


	public void setUserNameDTO(String userName) {
		this.userName = userName;
	}


	public String getProfilePicUrl() {
		return profilePicUrl;
	}


	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}
    
    
    
}