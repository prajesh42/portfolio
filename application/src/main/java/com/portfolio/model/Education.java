package com.portfolio.model;

import java.util.Date;

import com.portfolio.dto.EducationDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Education {

	private Long id;
	private String level;
	private Date startDate;
	private Date endDate;
	private String description;
	
	public EducationDTO mapEducation() {
		EducationDTO educationDTO = new EducationDTO();
		educationDTO.setId(id);
		educationDTO.setLevel(level);
		educationDTO.setStartDate(startDate);
		educationDTO.setEndDate(endDate);
		educationDTO.setDescription(description);
		return educationDTO;
	}
}
