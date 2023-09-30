
// package com.example.s3Bucket.SecuritySpring;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import java.util.List;
// import java.util.ArrayList;
// import com.example.s3Bucket.Creator.CreatorDev;
// import com.example.s3Bucket.Creator.CreatorRepo;

// public class CustomerDetails implements UserDetailsService {

	
// 	@Autowired
// 	CreatorRepo creatorRepo;
	
	
// 	@Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         CreatorDev creator = creatorRepo.findByEmail(email);
//         if (creator == null) {
//             throw new UsernameNotFoundException("User not found.");
//         }

//         List<GrantedAuthority> authorities = new ArrayList<>();
//         creator.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

//         return null; 
        
//     }

	
	
	
	
	
// }

//return new User(creator.getUsername(), creator.getPassword(), true, true, true, authorities);
	//new User(creator.getEmail(),creator.getPassWord(), creator);
       // return new User(creator.getEmail(), creator.getPassWord(), true, true, true,,  authorities);


//package com.example.s3Bucket.SecuritySpring;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class CustomerDetails implements UserDetailsService {
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		return null;
//	}
//	
//
//	
//}

