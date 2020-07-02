package engineeringthesis.androidrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class game {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameId")
	private Integer gameId;
	
	@Column(name = "gameName")
	private String gameName;
	
	
	public game() {}
	
	public game(String gameName){
		this.gameName = gameName;
	}

	public game(Integer gameId, String gameName) {
		this.gameId = gameId;
		this.gameName = gameName;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	@Override
	public String toString() {
		return "game [gameId=" + gameId + ", gameName=" + gameName + "]";
	}
	
	
	
	
}
