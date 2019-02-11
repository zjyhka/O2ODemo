package com.o2o;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	@GetMapping (value="hello")
	public String hello(){
		return "Hello SpringBoot!";
	}
}
