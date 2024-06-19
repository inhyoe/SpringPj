package com.in28minutes.rest.website.restful_web_services.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private final UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{userNumber}")
	public EntityModel<User> searchUsers(@PathVariable int userNumber) {
		User user = service.findOne(userNumber);
		if (user == null)
			throw new UserNotFoundException("id is exist " + userNumber);

		EntityModel<User> entityModel = EntityModel.of(user);

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		WebMvcLinkBuilder linkToEmployees = WebMvcLinkBuilder.linkTo(
			WebMvcLinkBuilder.methodOn(this.getClass()).searchUsers(userNumber));
		entityModel.add(link.withRel("all-users"));
		entityModel.add(linkToEmployees.withRel("specific user"));

		return entityModel;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		searchUsers(id);
		System.out.println("실행");
		service.deleteById(id);
	}

	@PostMapping(path = "/user-create")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getUserId())
			.toUri();

		// URI location = new URI("location", null, "");

		return ResponseEntity.created(location).build();
	}
}
