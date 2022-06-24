package com.portfolio.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.portfolio.model.Skill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "PORTFOLIO_SKILL")
@Entity	
public class SkillDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String skillName;
	private String rating;
	
	public Skill mapSkillDTO() {
		Skill skill = new Skill();
		skill.setId(id);
		skill.setSkillName(skillName);
		skill.setRating(rating);
		return skill;
	}
}
