package com.hotel.controller;

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

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	// Create
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
		
	}
	
	// Get By Id
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable ("id") String hotelId){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.getHotelById(hotelId));
	}
	
	// Get All Hotels
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
	
}
