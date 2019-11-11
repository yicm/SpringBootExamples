package com.xiaobaiai.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
public class UserServiceController {
	@Autowired
	UserService userService;
	
	@DeleteMapping({"/v1/users/{id}", "/v2/users/{id}"})
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
	}

	@PutMapping({"/v1/users/{id}", "/v2/users/{id}"})
	public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody User user) {
		userService.updateUser(id, user);
		return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
	}

	@PostMapping({"/v1/users", "/v2/users"})
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		userService.createUser(user);
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}

	@GetMapping({"/v1/users"})
	@Deprecated
	public ResponseEntity<Object> getUser() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/v2/users")
	public ResponseEntity<Object> getUser(@RequestParam String id) {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}
}
