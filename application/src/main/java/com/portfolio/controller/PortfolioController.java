package com.portfolio.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.portfolio.model.Profile;
import com.portfolio.service.PortfolioService;

@RestController
@RequestMapping("/user")
public class PortfolioController {

	@Autowired
	private PortfolioService portfolioService;

	@GetMapping("/profiles")
	public ResponseEntity<List<Profile>> getAllProfiles() {
		return ResponseEntity.ok(portfolioService.getAllProfiles());
	}

	@GetMapping("/profile/{id}")
	public ResponseEntity<Profile> getProfile(@PathVariable("id") String id) {
		return ResponseEntity.ok(portfolioService.getProfile(Long.parseLong(id)));
	}

	@PostMapping("/profile")
	public ResponseEntity<?> createProfile(@RequestBody Profile profile) {
		Profile createdProfile = portfolioService.createProfile(profile);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdProfile.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/profile")
	public ResponseEntity<?> updateProfile(@RequestBody Profile profile) {
		Profile updatedProfile = portfolioService.updateProfile(profile);
		if (updatedProfile != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/profile/{id}")
	public ResponseEntity<?> deleteProfile(@PathVariable("id") String id) {
		portfolioService.deleteProfile(Long.parseLong(id));
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
}
