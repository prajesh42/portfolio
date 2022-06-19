package com.portfolio.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.portfolio.model.ProjectDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "PROFILE_PROJECT_DETAIL")
@Entity
public class ProjectDetailDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private String title;
	private String description;
	
	public ProjectDetail mapProjectDetailDTO() {
		ProjectDetail projectDetail=new ProjectDetail();
		projectDetail.setId(id);
		projectDetail.setProjectName(projectName);
		projectDetail.setStartDate(startDate);
		projectDetail.setEndDate(endDate);
		projectDetail.setTitle(title);
		projectDetail.setDescription(description);
		return projectDetail;
	}
}
