 package com.example.s3Bucket.User;


import java.util.ArrayList;
import java.util.List;

import com.example.s3Bucket.Cart.Cart;
import com.example.s3Bucket.Favorites.Favorites;
import com.example.s3Bucket.Job.Job;
import com.example.s3Bucket.MyCollection.MyCollection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
	private String userName;
    private String email;
    private String passWord;
    private String profilePicUrl; 
    private List<String> interests = new ArrayList<>();
    private String contactNo;
    
    
    
    @OneToOne(mappedBy = "customer")
    private Cart cart;
    
    
    @OneToOne(mappedBy = "customer")
    private MyCollection collection;
    
    
    @OneToOne(mappedBy = "customer")
    private Favorites favorites;
    

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Job> jobs = new ArrayList<>();
    

	

    


    
    public Customer(List<Job> jobs) {
		this.jobs = jobs;
	}


	public String getProfilePicUrl() {
		return profilePicUrl;
	}


	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}



    
    
    public Long getUserId() {
        return userId;
    }
    

    // public void setUserId(int userId) {
    //     this.userId = userId;
    // }

    

	public String getFirstName() {
        return firstName;
    }
    
 

//    public List<Job> getJobs() {
//		return jobs;
//	}
//
//
//
//	public void setJobs(List<Job> jobs) {
//		this.jobs = jobs;
//	}



	public Favorites getFavorites() {
		return favorites;
	}



	public void setFavorites(Favorites favorites) {
		this.favorites = favorites;
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
   
//    
//    public byte[] getPreviewData3() {
//		return profilePic;
//	}
//
  
//	public void setPreviewData3(byte[] previewData3) {
//		this.profilePic = previewData3;
//	}

	
	
	

	//constructors 
	
//    public Customer(String firstName, String lastName, String userName, String email, String passWord, byte[] profilePic
//            ) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.passWord = passWord;
//        this.profilePic = profilePic;
//       
//    }
	
	
  
    public List<String> getInterests() {
		return interests;
	}



	public void setInterests(List<String> interests) {
		this.interests = interests;
	}


	

	public Customer() {

    }


	

	public Customer(String firstName, String lastName, String userName, String email, String passWord,
			String profilePicUrl,String contactNo, Cart cart, Favorites favorites) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		this.profilePicUrl = profilePicUrl;
		this.contactNo = contactNo;
		this.cart = cart;
		this.favorites = favorites;
	}



	
	
	public String  getProfilePic() {
		return profilePicUrl;
	}



	
	
	public void setProfilePic(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

	
	


	public String getContactNo() {
		return contactNo;
	}


	

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}



	public Cart getCart() {
		return cart;
	}



	public void setCart(Cart cart) {
		this.cart = cart;
	}

	


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	

	public MyCollection getCollection() {
		return collection;
	}


	public void setCollection(MyCollection collection) {
		this.collection = collection;
	}


	public Customer(String firstName, String lastName, String userName, String email, String passWord,
			String profilePicUrl, List<String> interests, String contactNo, Cart cart, MyCollection collection,
			Favorites favorites, List<Job> jobs) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		this.profilePicUrl = profilePicUrl;
		this.interests = interests;
		this.contactNo = contactNo;
		this.cart = cart;
		this.collection = collection;
		this.favorites = favorites;
		this.jobs = jobs;
	}
	
	

}
