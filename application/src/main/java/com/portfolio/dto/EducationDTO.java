package com.portfolio.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.portfolio.model.Education;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "PORTFOLIO_EDUCATION")
@Entity
public class EducationDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String level;
	private Date startDate;
	private Date endDate;
	private String description;

	public Education mapEducationDTO() {
		Education education = new Education();
		education.setId(id);
		education.setLevel(level);
		education.setStartDate(startDate);
		education.setEndDate(endDate);
		education.setDescription(description);
		return education;
	}
}
