package com.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {
	
	// Custom Finder Methods By UserId and HotelId
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);

}
