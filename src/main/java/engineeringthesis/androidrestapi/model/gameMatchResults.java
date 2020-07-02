package engineeringthesis.androidrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gameMatchResults")
public class gameMatchResults {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameMatchResultsId")
	private Integer gameMatchResultsId;
	
	@OneToOne
	@JoinColumn(name = "gameMatchId")
	private gameMatch gameMatchId;
	
	@OneToOne
	@JoinColumn(name = "statisticResultsId")
	private statisticResults statisticResultsId;
	
	public gameMatchResults() {}

	public gameMatchResults(Integer gameMatchResultsId, gameMatch gameMatchId, statisticResults statisticResultsId) {
		this.gameMatchResultsId = gameMatchResultsId;
		this.gameMatchId = gameMatchId;
		this.statisticResultsId = statisticResultsId;
	}
	
	public gameMatchResults( gameMatch gameMatchId, statisticResults statisticResultsId) {
		this.gameMatchId = gameMatchId;
		this.statisticResultsId = statisticResultsId;
	}

	public Integer getGameMatchResultsId() {
		return gameMatchResultsId;
	}

	public void setGameMatchResultsId(Integer gameMatchResultsId) {
		this.gameMatchResultsId = gameMatchResultsId;
	}

	public gameMatch getGameMatchId() {
		return gameMatchId;
	}

	public void setGameMatchId(gameMatch gameMatchId) {
		this.gameMatchId = gameMatchId;
	}

	public statisticResults getStatisticResultsId() {
		return statisticResultsId;
	}

	public void setStatisticResultsId(statisticResults statisticResultsId) {
		this.statisticResultsId = statisticResultsId;
	}

	@Override
	public String toString() {
		return "gameMatchResults [gameMatchResultsId=" + gameMatchResultsId + ", gameMatchId=" + gameMatchId
				+ ", statisticResultsId=" + statisticResultsId + "]";
	}
	
	
	
	
	
	
}
