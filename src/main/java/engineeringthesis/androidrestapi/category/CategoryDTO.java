package engineeringthesis.androidrestapi.category;

import engineeringthesis.androidrestapi.language.LanguageEntity;
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
	
	private LanguageEntity languageId;
	
	private boolean isNew;
	
	private boolean isAccepted;
}
