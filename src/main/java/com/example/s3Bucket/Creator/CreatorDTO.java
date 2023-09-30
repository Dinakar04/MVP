package com.example.s3Bucket.Creator;


public class CreatorDTO {

	private long userId;
	private String creatorName;
	private String profilePicUrl;
	
	//getters setters
	
	public long getUserId() {
		return userId;
	}
	
	
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	public String getCreatorName() {
		return creatorName;
	}
	
	
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	
	public String getProfilePicUrl() {
		return profilePicUrl;
	}
	
	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

	
	
	
	//constructors
	
	public CreatorDTO(long userId, String creatorName, String profilePicUrl) {
		super();
		this.userId = userId;
		this.creatorName = creatorName;
		this.profilePicUrl = profilePicUrl;
	}


	
	
	//empty constructors
	
	public CreatorDTO() {
		super();
	}
	

	
}
