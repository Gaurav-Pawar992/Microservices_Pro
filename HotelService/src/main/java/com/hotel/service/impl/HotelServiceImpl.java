package com.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		
		String randomHotelId = UUID.randomUUID().toString();
		
		hotel.setId(randomHotelId);
		
		return hotelRepository.save(hotel);
		
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found With Given Id " +hotelId));
	}

}
