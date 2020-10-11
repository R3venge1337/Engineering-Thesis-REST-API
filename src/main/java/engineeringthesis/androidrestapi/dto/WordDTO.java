package engineeringthesis.androidrestapi.dto;

import engineeringthesis.androidrestapi.entity.CategoryEntity;
import engineeringthesis.androidrestapi.entity.LanguageEntity;
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
	
	private CategoryEntity categoryId;
	
	private LanguageEntity languageId;
}
