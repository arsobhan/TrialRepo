package com.sample.review.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue
	@Column(name = "review_id")
	private long id;
	
	@Column(name = "movie_id")
	private long movieId;
	
	@Column(name = "review_desc")
	private String reviewDesc;
	

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(long id, long movieId, String reviewDesc) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.reviewDesc = reviewDesc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getReviewDesc() {
		return reviewDesc;
	}

	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}
	
	

}
