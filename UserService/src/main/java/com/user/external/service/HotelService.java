package com.user.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.entity.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {

	@GetMapping("hotels/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);
}
