package com.sample.moviereviewapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping(value="/admin", method = RequestMethod.GET)
    String index(){
        return "html/index";
    }
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
    String reviewList(){
        return "html/reviewlist";
    }

}

