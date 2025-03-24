package com.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entity.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	// Create
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}

	// Get All Ratings
		
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	
	// Get By UserId
	
	@GetMapping("/byUser/{id}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable ("id") String userId){
		return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
	}
	
	// Get By HotelId
	
	@GetMapping("/byHotel/{id}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable ("id") String hotelId){
		return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
	}
	
}

