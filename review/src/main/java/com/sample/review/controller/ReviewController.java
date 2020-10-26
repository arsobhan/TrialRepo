package com.sample.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.review.entity.Review;
import com.sample.review.model.ReviewItem;
import com.sample.review.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RequestMapping("/reviews")
@RestController
@Api(consumes="application/json", produces="application/json")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/review/{reviewId}")
	@ApiOperation(value="Finds Review by id", notes = "This call retrieves a review given the review id.", tags={"Review"}, httpMethod="GET")
	public ResponseEntity<Review> getReview(@PathVariable("reviewId") long id) {
		return new ResponseEntity<>(reviewService.getReview(id), HttpStatus.OK);	
	}
	
	@GetMapping("/{movieId}")
	@ApiOperation(value="Finds Review by movie id", notes = "This call retrieves a review given the movie id.", tags={"Review"}, httpMethod="GET")
	public ResponseEntity<List<String>> getAllReviews(@PathVariable("movieId") long movieId) {
		return new ResponseEntity<>(reviewService.getAllReviews(movieId), HttpStatus.OK);	
	}
	
	@PostMapping("/review")
	@ApiOperation(value="Adds a review for a movie", notes = "This call adds a new review for the movie.", tags={"Review"}, httpMethod="POST")
	public ResponseEntity<String> addReview(@RequestBody ReviewItem review){
		reviewService.addReview(review.getMovieId(), review.getReviewDesc());
		return new ResponseEntity<>("Review is added successfully", HttpStatus.CREATED);
	}

}
