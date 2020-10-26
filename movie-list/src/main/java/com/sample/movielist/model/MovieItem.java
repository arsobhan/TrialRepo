package com.sample.movielist.model;

import java.util.List;

public class MovieItem {
	
	private Long id;
	private String movieName;
	private String movieDesc;
	private List<String> review;
	
	
	
	public MovieItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieItem(Long id, String movieName, String movieDesc, List<String> review) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
		this.review = review;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDesc() {
		return movieDesc;
	}
	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}
	public List<String> getReview() {
		return review;
	}
	public void setReview(List<String> review) {
		this.review = review;
	}

	
}
