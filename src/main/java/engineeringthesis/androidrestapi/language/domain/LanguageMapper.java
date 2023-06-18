package engineeringthesis.androidrestapi.language.domain;

import engineeringthesis.androidrestapi.language.dto.LanguageDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class LanguageMapper implements Mapper<LanguageDTO, Language> {

	@Override
	public LanguageDTO mapOfEntity(Language entity) {
		
		LanguageDTO languageDTO = LanguageDTO.builder()
				.languageId(entity.getLanguageId())
				.languageName(entity.getLanguageName())
				//.languageImageIcon(entity.getLanguageImageIcon())
				.languageCreatedDate(entity.getLanguageCreatedDate())
				.isNew(entity.isNew())
				.isAccepted(entity.isAccepted())
				.build();
		
		return languageDTO;
	}

	@Override
	public Language mapOfDTO(LanguageDTO dto) {
		
		Language language = Language.builder()
				.languageId(dto.getLanguageId())
				.languageName(dto.getLanguageName())
				//.languageImageIcon(dto.getLanguageImageIcon())
				.languageCreatedDate(dto.getLanguageCreatedDate())
				.isNew(dto.isNew())
				.isAccepted(dto.isAccepted())
				.build();
		
		return language;
	}

}
