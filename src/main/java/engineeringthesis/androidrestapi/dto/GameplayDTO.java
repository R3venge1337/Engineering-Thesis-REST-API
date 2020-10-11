package engineeringthesis.androidrestapi.dto;

import java.time.LocalDateTime;
import engineeringthesis.androidrestapi.entity.CategoryEntity;
import engineeringthesis.androidrestapi.entity.ChildEntity;
import engineeringthesis.androidrestapi.entity.GameEntity;
import engineeringthesis.androidrestapi.entity.LanguageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class GameplayDTO {

	private Integer gameplayId;
	
	private LanguageEntity languageId;
	
	private GameEntity gameId;
	
	private CategoryEntity categoryId;

	private ChildEntity childId;
	
	private LocalDateTime gameMatchDataStart;
	
	private LocalDateTime gameMatchDataEnd;
}
