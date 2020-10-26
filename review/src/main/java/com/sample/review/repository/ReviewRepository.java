package com.sample.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sample.review.entity.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	@Query("SELECT r FROM Review r WHERE r.id = ?1")
	Review findByReviewId(long id);
	
	@Query("SELECT r.reviewDesc FROM Review r WHERE r.movieId = ?1")
	List<String> findByMovieId(long movieId);

}
