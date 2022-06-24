package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HelloWorldRestController {

	private final Environment environment;

	@RequestMapping
	public ResponseEntity<String> getStatus()
	{
		String response="application is up and runing on port: "+environment.getProperty("local.server.port");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello()
	{
		return ResponseEntity.status(HttpStatus.OK).body("hello world rest-api");
	}

}
