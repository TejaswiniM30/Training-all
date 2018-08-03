package com.training.exilant.restfulworks.user;

import java.net.URI;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.training.exilant.restfulworks.exception.UserNotFoundException;

@RestController
public class UserResource {
	@Autowired
	private UserDAOService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/usersold/{userId}")
	public User getOneUser(@PathVariable int userId) {
		User getUser = userService.getUser(userId);
		if(getUser == null) {
			throw new UserNotFoundException("ID: "+userId);
		}
		return getUser;
	}
	////////////////////////////////////////////////
	//will give the user + give the reference links to the caller with additional links
	@GetMapping("/users/{userId}")
	public Resource<User> getOneUserv2(@PathVariable int userId) {
		User getUser = userService.getUser(userId);
		if(getUser == null) {
			throw new UserNotFoundException("ID: "+userId);
		}
		
		//give the link for getting all users with meta data "all-users"
		//SERVER-PATH + "/users"
		
		Resource<User> resource = new Resource<User>(getUser);
		
		ControllerLinkBuilder linkTo = new ControllerLinkBuilderFactory().linkTo(methodOn(this.getClass()).getAllUsers());
		ControllerLinkBuilder linkTo1 = new ControllerLinkBuilderFactory().linkTo(methodOn(this.getClass()).getOneUser(userId));

		resource.add(linkTo.withRel("all-users"));
		resource.add(linkTo1.withRel("another-way-of-requesting"));
		return resource;
	}

	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		System.out.println("Saved User " + savedUser);
	}
	
	////////////////////////////////////////////////
	//will give the user + give the reference links to the caller with additional links
	@PostMapping("/usersv1")
	public Resource<User> createUser1(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		System.out.println("Saved User " + savedUser);
		Resource<User> resource = new Resource<User>(savedUser);
		System.out.println(resource.getContent().getUserName());
		//ControllerLinkBuilder linkTo = new ControllerLinkBuilderFactory().linkTo(methodOn(this.getClass()).createUserResponseCode(user));
		ControllerLinkBuilder linkTo = new ControllerLinkBuilderFactory().linkTo(methodOn(this.getClass()).getOneUser(savedUser.getUserId()));
		//ControllerLinkBuilder linkTo = new ControllerLinkBuilderFactory().linkTo(methodOn(this.getClass()).getOneUser(102));
		System.out.println(linkTo.toUri().toString());
		//resource.add(linkTo.withRel("To get with location of the added user use this url"));
		resource.add(linkTo.withRel("added-user-link"));

		//resource.add(linkTo.withRel("Access added user here: "));
		return resource;
	}


	@PostMapping("/usersv2")
	public ResponseEntity<Object> createUserResponseCode(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(savedUser.getUserId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@GetMapping("/delete/{userId}")
	public User deleteUser(@PathVariable int userId) {
		return userService.deleteUser(userId);
	}
	
	@PostMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	
}
