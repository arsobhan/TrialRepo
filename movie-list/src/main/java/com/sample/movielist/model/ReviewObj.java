package com.sample.movielist.model;

public class ReviewObj {
	
		
		private long id;
		
		private long movieId;
		
		private String reviewDesc;

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
