package com.portfolio.model;

import java.util.Date;

import javax.persistence.Column;

import com.portfolio.dto.ExperienceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Experience {

	private Long id;
	private String company;
	private Date startDate;
	private Date endDate;
	@Column(length = 5000)
	private String details;
	
	public ExperienceDTO mapExperience() {
		ExperienceDTO experienceDTO = new ExperienceDTO();
		experienceDTO.setId(id);
		experienceDTO.setCompany(company);
		experienceDTO.setStartDate(startDate);
		experienceDTO.setEndDate(endDate);
		experienceDTO.setDetails(details);
		return experienceDTO;
	}
}
