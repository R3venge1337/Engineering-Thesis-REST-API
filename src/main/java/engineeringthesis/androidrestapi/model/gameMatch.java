package engineeringthesis.androidrestapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "gameMatch")
public class gameMatch {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameMatchId")
	private Integer gameMatchId;
	
	@OneToOne
	@JoinColumn(name = "languageId")
	private language languageId;
	
	@OneToOne
	@JoinColumn(name = "gameId")
	private game gameId;
	
	@OneToOne
	@JoinColumn(name = "categoryId")
	private category categoryId;
	
	@OneToOne
	@JoinColumn(name = "childId")
	private child childId;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "gameMatchDataStart")
		private Date gameMatchDataStart;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "gameMatchDataEnd")
		private Date gameMatchDataEnd;
	
	public gameMatch() {}
	

	public gameMatch(game gameId, category categoryId, child childId, Date gameMatchDataStart,
			Date gameMatchDataEnd) {
		this.gameId = gameId;
		this.categoryId = categoryId;
		this.childId = childId;
		this.gameMatchDataStart = gameMatchDataStart;
		this.gameMatchDataEnd = gameMatchDataEnd;
	}




	public gameMatch(Integer gameMatchId, language languageId, game gameId, category categoryId, child childId,
			Date gameMatchDataStart, Date gameMatchDataEnd) {
		this.gameMatchId = gameMatchId;
		this.languageId = languageId;
		this.gameId = gameId;
		this.categoryId = categoryId;
		this.childId = childId;
		this.gameMatchDataStart = gameMatchDataStart;
		this.gameMatchDataEnd = gameMatchDataEnd;
	}

	public Integer getGameMatchId() {
		return gameMatchId;
	}

	public void setGameMatchId(Integer gameMatchId) {
		this.gameMatchId = gameMatchId;
	}

	public language getLanguageId() {
		return languageId;
	}

	public void setLanguageId(language languageId) {
		this.languageId = languageId;
	}

	public game getGameId() {
		return gameId;
	}

	public void setGameId(game gameId) {
		this.gameId = gameId;
	}

	public category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(category categoryId) {
		this.categoryId = categoryId;
	}

	public child getChildId() {
		return childId;
	}

	public void setChildId(child childId) {
		this.childId = childId;
	}

	public Date getGameMatchDataStart() {
		return gameMatchDataStart;
	}

	public void setGameMatchDataStart(Date gameMatchDataStart) {
		this.gameMatchDataStart = gameMatchDataStart;
	}

	public Date getGameMatchDataEnd() {
		return gameMatchDataEnd;
	}

	public void setGameMatchDataEnd(Date gameMatchDataEnd) {
		this.gameMatchDataEnd = gameMatchDataEnd;
	}

	@Override
	public String toString() {
		return "gameMatch [gameMatchId=" + gameMatchId + ", languageId=" + languageId + ", gameId=" + gameId
				+ ", categoryId=" + categoryId + ", childId=" + childId + ", gameMatchDataStart=" + gameMatchDataStart
				+ ", gameMatchDataEnd=" + gameMatchDataEnd + "]";
	}
	
	
	
	
	
}
