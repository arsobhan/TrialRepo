package com.sample.review.service;

import java.util.List;

import com.sample.review.entity.Review;

public interface ReviewService{
	
	public abstract void addReview(long movieId, String ReviewDesc);
	public abstract Review getReview(long id);
	public abstract List<String> getAllReviews(long movieId);

}