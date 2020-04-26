package postgres.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import postgres.model.User;
import postgres.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/CreateUser")
	public ResponseEntity<User> createUserFromId() {
		User user = userService.create();
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@RequestMapping("/GetUser")
	public ResponseEntity<User> getUserFromId(@RequestParam long id) {
		Optional<User> user = userService.getByID(id);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
}
