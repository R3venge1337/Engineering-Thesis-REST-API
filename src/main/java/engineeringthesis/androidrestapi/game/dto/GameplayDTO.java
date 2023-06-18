package engineeringthesis.androidrestapi.game.dto;

import java.time.LocalDateTime;

import engineeringthesis.androidrestapi.category.domain.CategoryEntity;
import engineeringthesis.androidrestapi.game.domain.GameEntity;
import engineeringthesis.androidrestapi.language.domain.LanguageEntity;
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
