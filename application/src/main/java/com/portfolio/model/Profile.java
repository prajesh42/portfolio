package com.portfolio.model;

import java.util.Set;
import java.util.stream.Collectors;

import com.portfolio.dto.ProfileDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

	private Long id;
	private String name;
	private Address address;
	private Set<Education> educations;
	private Set<Skill> skills;
	private Set<Language> languages;
	private Set<Experience> experiences;
	private Set<ProjectDetail> projects;

	public ProfileDTO mapProfile() {
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setId(id);
		profileDTO.setName(name);
		profileDTO.setEducations(educations.stream().map(Education::mapEducation).collect(Collectors.toSet()));
		profileDTO.setAddress(address.mapAddress());
		profileDTO.setSkills(skills.stream().map(Skill::mapSkill).collect(Collectors.toSet()));
		profileDTO.setLanguages(languages.stream().map(Language::mapLanguage).collect(Collectors.toSet()));
		profileDTO.setProjects(projects.stream().map(ProjectDetail::mapProjectDetail).collect(Collectors.toSet()));
		profileDTO.setExperiences(experiences.stream().map(Experience::mapExperience).collect(Collectors.toSet()));
		return profileDTO;
	}
}
