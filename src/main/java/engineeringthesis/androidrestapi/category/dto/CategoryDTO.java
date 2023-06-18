package engineeringthesis.androidrestapi.category.dto;

import engineeringthesis.androidrestapi.language.domain.LanguageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class CategoryDTO {
	
	private Integer categoryId;
	
	private String categoryName;
	
	private Language languageId;
	
	private boolean isNew;
	
	private boolean isAccepted;
}
