package com.portfolio.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.portfolio.model.Language;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "PORTFOLIO_LANGUAGE")
@Entity
public class LanguageDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String code;

	public Language mapLanguageDTO() {
		Language language = new Language();
		language.setId(id);
		language.setName(name);
		language.setCode(code);
		return language;
	}
}
