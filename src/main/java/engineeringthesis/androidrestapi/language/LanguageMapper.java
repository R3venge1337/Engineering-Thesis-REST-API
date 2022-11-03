package engineeringthesis.androidrestapi.language;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.util.Mapper;

@Component
public class LanguageMapper implements Mapper<LanguageDTO,LanguageEntity> {

	@Override
	public LanguageDTO mapOfEntity(LanguageEntity entity) {
		
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
	public LanguageEntity mapOfDTO(LanguageDTO dto) {
		
		LanguageEntity languageEntity = LanguageEntity.builder()
				.languageId(dto.getLanguageId())
				.languageName(dto.getLanguageName())
				//.languageImageIcon(dto.getLanguageImageIcon())
				.languageCreatedDate(dto.getLanguageCreatedDate())
				.isNew(dto.isNew())
				.isAccepted(dto.isAccepted())
				.build();
		
		return languageEntity;
	}

}
