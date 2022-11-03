package engineeringthesis.androidrestapi.game;

import java.time.LocalDateTime;

import engineeringthesis.androidrestapi.category.CategoryEntity;
import engineeringthesis.androidrestapi.language.LanguageEntity;
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
	/*
	private ChildEntity childId;
	*/
	private String questUUID;
	
	private LocalDateTime gameMatchDataStart;
	
	private LocalDateTime gameMatchDataEnd;
}
