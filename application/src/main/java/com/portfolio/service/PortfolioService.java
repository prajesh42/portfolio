package com.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.dao.ProfileRepository;
import com.portfolio.dto.ProfileDTO;
import com.portfolio.model.Profile;

@Service
public class PortfolioService {

	private ProfileRepository profileRepository;

	@Autowired
	public void setPortfolioService(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	public List<Profile> getAllProfiles() {
		return profileRepository.findAll().stream().map(ProfileDTO::mapProfileDTO).toList();
	}

	public Profile getProfile(Long id) {
		return profileRepository.findById(id).get().mapProfileDTO();
	}

	public Profile createProfile(Profile profile) {
		return profileRepository.save(profile.mapProfile()).mapProfileDTO();
	}

	public Profile updateProfile(Profile profile) {
		if (profileRepository.existsById(profile.getId())) {
			return profileRepository.save(profile.mapProfile()).mapProfileDTO();
		}
		return null;
	}

	public void deleteProfile(Long profileId) {
		profileRepository.deleteById(profileId);
	}
}
