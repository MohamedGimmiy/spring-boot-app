package net.javaguides.springbootrestefulwebservice.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestefulwebservice.entity.User;
import net.javaguides.springbootrestefulwebservice.repository.UserRepository;


@RestController
@AllArgsConstructor
@RequestMapping(path="api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userRepository.save(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userRepository.findAll();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
		Optional<User> user = userRepository.findById(userId);
		return new ResponseEntity<>(user.get(),HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable("id") Long userId,
			@RequestBody User user
			){
		user.setId(userId);
		User updatedUser = userRepository.save(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
		userRepository.deleteById(userId);
		return new ResponseEntity<>("User deleted successfully!",HttpStatus.OK);
		
	}
	
	
}
