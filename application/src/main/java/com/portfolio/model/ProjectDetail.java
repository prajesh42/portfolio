package com.portfolio.model;

import java.util.Date;

import com.portfolio.dto.ProjectDetailDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDetail {
	private Integer id;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private String title;
	private String description;
	
	public ProjectDetailDTO mapProjectDetail() {
		ProjectDetailDTO projectDetailDTO=new ProjectDetailDTO();
		projectDetailDTO.setId(id);
		projectDetailDTO.setProjectName(projectName);
		projectDetailDTO.setStartDate(startDate);
		projectDetailDTO.setEndDate(endDate);
		projectDetailDTO.setTitle(title);
		projectDetailDTO.setDescription(description);
		return projectDetailDTO;
	}
}
