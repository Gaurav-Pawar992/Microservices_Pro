package com.rating.service;

import java.util.List;

import com.rating.entity.Rating;

public interface RatingService {
	
	// Create
	
	Rating createRating(Rating rating);
	
	// Get All Ratings
	
	List<Rating> getAllRatings();
	
	// Get All Ratings By UserId;
	
	List<Rating> getRatingsByUserId(String userId);
	
	// Get All Ratings By HotelId
	
	List<Rating> getRatingsByHotelId(String hotelId);

}
