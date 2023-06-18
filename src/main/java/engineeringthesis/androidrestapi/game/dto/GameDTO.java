package engineeringthesis.androidrestapi.game.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class GameDTO {
   
	private Integer gameId;
	
	private String gameName;
}
