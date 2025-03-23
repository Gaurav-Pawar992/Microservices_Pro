package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {

	// Create
	
	Hotel createHotel(Hotel hotel);
	
	// Get All Hotels
	
	List<Hotel> getAllHotels();
	
	// Get Hotel By Id
	
	Hotel getHotelById(String hotelId);
	
}
