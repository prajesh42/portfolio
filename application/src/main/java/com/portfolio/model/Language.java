package com.portfolio.model;

import com.portfolio.dto.LanguageDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Language {

	private Long id;
	private String name;
	private String code;
	
	public LanguageDTO mapLanguage() {
		LanguageDTO languageDTO = new LanguageDTO();
		languageDTO.setId(id);
		languageDTO.setName(name);
		languageDTO.setCode(code);
		return languageDTO;
	}
}
