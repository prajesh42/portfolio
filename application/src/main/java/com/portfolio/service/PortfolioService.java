package com.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.Exception.PortfolioDataException;
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

	public List<Profile> getAllProfiles() throws PortfolioDataException {
		try {
			return profileRepository.findAll().stream().map(ProfileDTO::mapProfileDTO).toList();
		} catch (Exception pe) {
			throw new PortfolioDataException("PORTFOLIO-210101", "Error occurred while getting profiles from db", null);
		}
	}

	public Profile getProfile(Long id) throws PortfolioDataException {
		try {
			return profileRepository.findById(id).get().mapProfileDTO();
		} catch (Exception pe) {
			throw new PortfolioDataException("PORTFOLIO-210201",
					"Error occurred while getting profile for id " + id + " from db", null);
		}
	}

	public Profile createProfile(Profile profile) throws PortfolioDataException {
		try {
			return profileRepository.save(profile.mapProfile()).mapProfileDTO();
		} catch (Exception pe) {
			throw new PortfolioDataException("PORTFOLIO-210301", "Error occurred while creating profile in db", null);
		}
	}

	public Profile updateProfile(Profile profile) throws PortfolioDataException {
		try {
			if (profileRepository.existsById(profile.getId())) {
				return profileRepository.save(profile.mapProfile()).mapProfileDTO();
			}
			return null;
		} catch (Exception pe) {
			throw new PortfolioDataException("PORTFOLIO-210401", "Error occurred while updating profile in db", null);
		}
	}

	public void deleteProfile(Long profileId) throws PortfolioDataException {
		try {
			profileRepository.deleteById(profileId);
		} catch (Exception pe) {
			throw new PortfolioDataException("PORTFOLIO-210501", "Error occurred while deleting profile from db", null);
		}
	}
}
