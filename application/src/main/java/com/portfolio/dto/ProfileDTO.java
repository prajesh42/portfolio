package com.portfolio.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.portfolio.model.Profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PORTFOLIO_PROFILE")
@Entity
public class ProfileDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_address_id")
	private AddressDTO address;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_education_id", referencedColumnName = "id")
	private Set<EducationDTO> educations = new HashSet<>(0);
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_skill_id", referencedColumnName = "id")
	private Set<SkillDTO> skills = new HashSet<>(0);
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_language_id", referencedColumnName = "id")
	private Set<LanguageDTO> languages = new HashSet<>(0);
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_experience_id", referencedColumnName = "id")
	private Set<ExperienceDTO> experiences = new HashSet<>(0);
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_project_id", referencedColumnName = "id")
	private Set<ProjectDetailDTO> projects = new HashSet<>(0);

	public Profile mapProfileDTO() {
		Profile profile = new Profile();
		profile.setId(id);
		profile.setName(name);
		profile.setEducations(educations.stream().map(EducationDTO::mapEducationDTO).collect(Collectors.toSet()));
		profile.setAddress(address.mapAddressDTO());
		profile.setSkills(skills.stream().map(SkillDTO::mapSkillDTO).collect(Collectors.toSet()));
		profile.setLanguages(languages.stream().map(LanguageDTO::mapLanguageDTO).collect(Collectors.toSet()));
		profile.setProjects(projects.stream().map(ProjectDetailDTO::mapProjectDetailDTO).collect(Collectors.toSet()));
		profile.setExperiences(experiences.stream().map(ExperienceDTO::mapExperienceDTO).collect(Collectors.toSet()));
		return profile;
	}
}
