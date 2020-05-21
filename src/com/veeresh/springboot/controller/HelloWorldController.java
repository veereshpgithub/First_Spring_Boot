package com.veeresh.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veeresh.springboot.bean.HelloWorldBean;
import com.veeresh.springboot.bean.Product;


@RestController
public class HelloWorldController {

	private static Map<String, Product> productRepo = new HashMap<>();
	   
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	public ResponseEntity<Object> helloWorld() {
		
		Product honey = new Product();
	      honey.setId("1");
	      honey.setName("Honey");
	      productRepo.put(honey.getId(), honey);
	      
	      Product almond = new Product();
	      almond.setId("2");
	      almond.setName("Almond");
	      productRepo.put(almond.getId(), almond);
	      
		return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	}

	@RequestMapping(path = "/helloworldbean", method = RequestMethod.POST)
	public ResponseEntity<Object> helloWorldBean(@RequestBody HelloWorldBean bean) {
		System.out.println("Request body ====>  "+ bean);
		return new ResponseEntity<>(bean.getMessage(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}") 
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
