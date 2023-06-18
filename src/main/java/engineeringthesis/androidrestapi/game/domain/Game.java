package engineeringthesis.androidrestapi.game.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "game")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class Game {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id_pk")
	private Integer gameId;
	
	@Column(name = "game_name")
	private String gameName;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
}
