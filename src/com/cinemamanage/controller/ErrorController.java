package com.cinemamanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {
	@RequestMapping(value = "/toError",method = RequestMethod.GET)
	public String toError() {
		return "errorPage";
	}
}