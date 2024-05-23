package com.srore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srore.imple.storeImplementation;
import com.srore.mainStore.mainStore;


@RestController
@RequestMapping("/home")
public class storeController {
	
	@Autowired
	private storeImplementation  storeImp;
	
	@GetMapping(value = "/getAll")
	public List<mainStore> getAll() {
		return storeImp.getAll();
	}
	
	@GetMapping(value = "/admin")
	public ResponseEntity<String> admin(){
		return ResponseEntity.ok("I am admin method");
	}

	@GetMapping(value = "/user")
	public ResponseEntity<String> users(){
		return new ResponseEntity<>("I am in user field", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getSingle/{id}")
	public mainStore getSingle(@PathVariable String id) {
		return storeImp.getSingle(id);
	}
	
	
	
}
