package com.portfolio.model;

import com.portfolio.dto.SkillDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

	private Long id;
	private String skillName;
	private String rating;

	public SkillDTO mapSkill() {
		SkillDTO skillDTO = new SkillDTO();
		skillDTO.setId(id);
		skillDTO.setSkillName(skillName);
		skillDTO.setRating(rating);
		return skillDTO;
	}
}
