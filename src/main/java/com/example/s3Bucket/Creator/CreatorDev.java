package com.example.s3Bucket.Creator;

import java.util.List;
import java.util.ArrayList;

import com.example.s3Bucket.Favorites.Favorites;
import com.example.s3Bucket.File.FileMetadata;
// import com.example.s3Bucket.Job.Job;
import com.example.s3Bucket.Job.Job;
import com.example.s3Bucket.onGoingJob.OngoingJobs;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class CreatorDev {
	
	
		
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private long creatorId;
		private byte[] profilePic;
	    private String firstName;
	    private String lastName;
		private String userName;
	    private String email ;
	    private String passWord;
	    private String contactNo;

	    private List<String> interests;// = new ArrayList<>();
	    private String skillLevel;//= "";
	    private List<String> platformsUsing;// = new ArrayList<>();
	    private List<String> DevelopingSkill;// = new ArrayList<>();
	    private List<String> vrDevices;// = new ArrayList<>();
	    
	    @ElementCollection(fetch = FetchType.EAGER)
	    @CollectionTable(name = "creator_roles", joinColumns = @JoinColumn(name = "creator_id"))
	    @Column(name = "role")
	    private List<String> roles = new ArrayList<>();

	    
		@OneToOne(mappedBy = "creator")
		private OngoingJobs ongoinJobs;
		

		
		public List<String> getRoles() {
			return roles;
		}

		public void setRoles(List<String> roles) {
			this.roles = roles;
		}

		
		public String getSkillLevel() {
			return skillLevel;
		}

//
//		public Favorites getFavorites() {
//			return favorites;
//		}


//		public void setFavorites(Favorites favorites) {
//			this.favorites = favorites;
//		}
//
		

		public long getCreatorId() {
			return creatorId;
		}

		
		public String getContactNo() {
			return contactNo;
		}

		
		
		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}

		
		
		public void setCreatorId(long creatorId) {
			this.creatorId = creatorId;
		}

		
		public byte[] getProfilePic() {
			return profilePic;
		}

		
		public void setProfilePic(byte[] profilePic) {
			this.profilePic = profilePic;
		}

		
		public void setSkillLevel(String skillLevel) {
			this.skillLevel = skillLevel;
		}

		

		public List<String> getPlatformsUsing() {
			return platformsUsing;
		}


		public void setPlatformsUsing(List<String> platformsUsing) {
			this.platformsUsing = platformsUsing;
		}


		public List<String> getDevelopingSkill() {
			return DevelopingSkill;
		}


		public void setDevelopingSkill(List<String> developingSkill) {
			DevelopingSkill = developingSkill;
		}


		public List<String> getVrDevices() {
			return vrDevices;
		}


		public void setVrDevices(List<String> vrDevices) {
			this.vrDevices = vrDevices;
		}


//		public long getCustomerId() {
//			return creatorId;
//		}
		
		
		
		public String getFirstName() {
			return firstName;
		}
		
		
		
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		
		
		
		public String getLastName() {
			return lastName;
		}
		
		
		
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		
		
		public String getUserName() {
			return userName;
		}
		
		
		
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		
		
		public String getEmail() {
			return email;
		}
		
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		
		public String getPassWord() {
			return passWord;
		}
		
		
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		
		

		
		public List<String> getInterests() {
			return interests;
		}
		
		
		
		
		public void setInterests(List<String> interests) {
			this.interests = interests;
		}


		
		
		public CreatorDev(String firstName, String lastName, String userName, String email, String passWord
				,List<String> interests) {
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.email = email;
			this.passWord = passWord;
			this.interests = interests;
			
		}
		
		
		
		public CreatorDev(byte[] profilePic, String firstName, String lastName, String userName, String email,
				String passWord, String contactNo, List<String> interests, String skillLevel,
				List<String> platformsUsing, List<String> developingSkill, List<String> vrDevices, List<String> roles,
				OngoingJobs ongoinJobs) {
			this.profilePic = profilePic;
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.email = email;
			this.passWord = passWord;
			this.contactNo = contactNo;
			this.interests = interests;
			this.skillLevel = skillLevel;
			this.platformsUsing = platformsUsing;
			DevelopingSkill = developingSkill;
			this.vrDevices = vrDevices;
			this.roles = roles;
			this.ongoinJobs = ongoinJobs;
		}

		public CreatorDev() {
			
		}

		public OngoingJobs getOngoinJobs() {
			return ongoinJobs;
		}

		public void setOngoinJobs(OngoingJobs ongoinJobs) {
			this.ongoinJobs = ongoinJobs;
		}



}
