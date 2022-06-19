package com.portfolio.model;

import java.util.HashSet;
import java.util.Set;

import com.portfolio.dto.ProfileDTO;
import com.portfolio.dto.ProjectDetailDTO;

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
	private String education;
	private String skills;
	private String languages;
	private String experiences;
	private Set<ProjectDetail> projects;

	public ProfileDTO mapProfile() {
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setId(id);
		profileDTO.setName(name);
		profileDTO.setEducation(education);
		profileDTO.setAddress(address.mapAddress());
		profileDTO.setSkills(skills);
		profileDTO.setLanguages(languages);
		Set<ProjectDetailDTO> projectDetails=new HashSet<ProjectDetailDTO>();
		for(ProjectDetail projectDetail: projects) {
			projectDetails.add(projectDetail.mapProjectDetail());
		}
		profileDTO.setProjects(projectDetails);
		profileDTO.setExperiences(experiences);
		return profileDTO;
	}
}
