package com.portfolio.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.portfolio.model.Experience;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "PORTFOLIO_EXPERIENCE")
@Entity
public class ExperienceDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String company;
	private Date startDate;
	private Date endDate;
	@Column(length = 5000)
	private String details;

	public Experience mapExperienceDTO() {
		Experience experience = new Experience();
		experience.setId(id);
		experience.setCompany(company);
		experience.setStartDate(startDate);
		experience.setEndDate(endDate);
		experience.setDetails(details);
		return experience;
	}
}
