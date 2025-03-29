package com.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	
	// Added For Feign Client Post Method Test
	
	/*
	 * @Autowired private RatingService ratingService;
	 * 
	 * @Test void createRating() {
	 * 
	 * Rating rating = Rating.builder().rating(8).userId("").hotelId("").
	 * feedback("Using Feign Client").build();
	 * 
	 * Rating saveRating = ratingService.createRating(rating);
	 * 
	 * System.out.println("New Rating Created !!");
	 * 
	 * }
	 */
}
