package com.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Hotel;
import com.user.entity.Rating;
import com.user.entity.User;
import com.user.exceptions.ResourceNotFoundException;
import com.user.external.service.HotelService;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	// Added Dependency Injection For Feign Client
	
	@Autowired
	private HotelService hotelService;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		String randomUserId=UUID.randomUUID().toString();
		
		user.setUserId(randomUserId);
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given Id + " + userId + " not found."));
		
		// To fetch rating of above user from RatingService
		
		// http://localhost:8083/ratings/byUser/e07603db-e04b-46c3-9e12-c37e20f33148
		
		// Shows Error LinkedHashMap
		//ArrayList<Rating> ratingsOfUser =  restTemplate.getForObject("http://localhost:8083/ratings/byUser/"+user.getUserId(), ArrayList.class);
		
		Rating[] ratingsArray =  restTemplate.getForObject("http://RATINGSERVICE/ratings/byUser/"+user.getUserId(), Rating[].class);
		
		List<Rating> ratingsOfUser = Arrays.stream(ratingsArray).toList();
		
		logger.info("{} " , ratingsOfUser);

		List<Rating> ratingList =  ratingsOfUser.stream().map(rating -> {
			
			// API call to HotelService to get Hotel
			
			//http://localhost:8082/hotels/f62c70d7-7d9f-43ee-9447-eff9c01d7070
			
			
			// Using RestTemplate
			
			//ResponseEntity<Hotel> entity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			//Hotel hotel = entity.getBody();
			// logger.info("Response Status Code : " , entity.getStatusCode());
			
			// Using Feign Client
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			
			
			// Set Hotel to Rating
			
			rating.setHotel(hotel);
			
			// Return the Rating
			
			return rating;
			
			
		}).collect(Collectors.toList());
		
		
		user.setRatings(ratingList);
		
		// For giving only ratings
		//user.setRatings(ratingsOfUser);
		
		return user;
	}
	


}
