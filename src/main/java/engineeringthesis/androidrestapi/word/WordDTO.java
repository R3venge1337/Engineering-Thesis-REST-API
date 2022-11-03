package engineeringthesis.androidrestapi.word;

import engineeringthesis.androidrestapi.audio.AudioEntity;
import engineeringthesis.androidrestapi.category.CategoryEntity;
import engineeringthesis.androidrestapi.image.ImageEntity;
import engineeringthesis.androidrestapi.language.LanguageEntity;
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
