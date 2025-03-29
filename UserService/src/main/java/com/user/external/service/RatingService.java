package com.user.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.entity.Rating;

@Service
@FeignClient(name="RATINGSERVICE")
public interface RatingService {
	
	// Create
	
	@PostMapping("/ratings")
	public Rating createRating (Rating rating);

	
}
