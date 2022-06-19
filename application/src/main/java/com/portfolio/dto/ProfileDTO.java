package com.portfolio.dto;

import java.util.HashSet;
import java.util.Set;

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
import com.portfolio.model.ProjectDetail;

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
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_address_id")
	private AddressDTO address;
	private String education;
	private String skills;
	private String languages;
	private String experiences;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_project_id",referencedColumnName = "id")
	private Set<ProjectDetailDTO> projects=new HashSet<>(0);
	
	public Profile mapProfileDTO() {
		Profile profile = new Profile();
		profile.setId(id);
		profile.setName(name);
		profile.setEducation(education);
		profile.setAddress(address.mapAddressDTO());
		profile.setSkills(skills);
		profile.setLanguages(languages);
		Set<ProjectDetail> projectDetails=new HashSet<ProjectDetail>();
		for(ProjectDetailDTO projectDetail: projects) {
			projectDetails.add(projectDetail.mapProjectDetailDTO());
		}
		profile.setProjects(projectDetails);
		profile.setExperiences(experiences);
		return profile;
	}
}
