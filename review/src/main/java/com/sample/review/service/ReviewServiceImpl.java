package com.sample.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.review.entity.Review;
import com.sample.review.repository.ReviewRepository;
import com.sample.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewRepository ReviewRepository;

	@Override
	public void addReview(long movieId, String reviewDesc) {
		Review review = new Review();
		review.setMovieId(movieId);
		review.setReviewDesc(reviewDesc);
		ReviewRepository.save(review);
	}

	@Override
	public Review getReview(long id) {
		return ReviewRepository.findByReviewId(id);
	}

	@Override
	public List<String> getAllReviews(long movieId) {
		List<String> reviews = ReviewRepository.findByMovieId(movieId);
		return reviews;
	}
	

}
