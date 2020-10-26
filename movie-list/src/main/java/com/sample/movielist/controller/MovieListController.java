package com.sample.movielist.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.movielist.model.MovieItem;
import com.sample.movielist.model.MovieObj;
import com.sample.movielist.model.ReviewObj;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/movielist")
@Api(consumes="application/json", produces="application/json")
public class MovieListController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/")
	@ApiOperation(value="Finds all movies along with reviews", notes = "This call retrieves all movies and respective reviews", tags={"Movie Review"}, httpMethod="GET")
	public List<MovieItem> getMovieList(){
		
		MovieObj[] response = restTemplate.getForObject("http://localhost:8060/movie-service/movies/", MovieObj[].class);
		List<MovieObj> movies = Arrays.asList(response);
		return movies.stream().map(movie -> {
				String[] reviews = restTemplate.getForObject("http://localhost:8060/review-service/reviews/"+movie.getId(), String[].class);
				return new MovieItem(movie.getId(), movie.getMovieName(), movie.getMovieDesc(),Arrays.asList(reviews));
		}).collect(Collectors.toList());
	}

}
