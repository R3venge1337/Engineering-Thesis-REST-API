package engineeringthesis.androidrestapi.word.dto;

import engineeringthesis.androidrestapi.audio.AudioEntity;
import engineeringthesis.androidrestapi.category.domain.CategoryEntity;
import engineeringthesis.androidrestapi.image.domain.ImageEntity;
import engineeringthesis.androidrestapi.language.domain.LanguageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class WordDTO {

	private Integer wordId;
	
	private String wordName;
	
	private String wordDownloadUri;
	
	private CategoryEntity categoryId;
	
	private LanguageEntity languageId;
	
	private ImageEntity imageId;
	
	private AudioEntity audioId;
}
