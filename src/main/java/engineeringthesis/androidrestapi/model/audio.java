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
@Table(name = "audio")
public class audio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audioId")
	private Integer audioId;
	
	@Column(name = "audioName")
	private String audioName;
	  
	@Column(name = "audioFileDir")
	private String audioFileDir;
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "audioCreatedDate")
	private Date audioCreatedDate;
	
	@OneToOne
	@JoinColumn(name = "wordId")
	private word wordId;
	
	public audio() {}

	public audio(String audioName, String audioFileDir, Date audioCreatedDate, word wordId) {
		
		this.audioName = audioName;
		this.audioFileDir = audioFileDir;
		this.audioCreatedDate = audioCreatedDate;
		this.wordId = wordId;
	}
	
	

	public audio(Integer audioId, String audioName, String audioFileDir, Date audioCreatedDate, word wordId) {
		
		this.audioId = audioId;
		this.audioName = audioName;
		this.audioFileDir = audioFileDir;
		this.audioCreatedDate = audioCreatedDate;
		this.wordId = wordId;
	}

	public Integer getAudioId() {
		return audioId;
	}

	public void setAudioId(Integer audioId) {
		this.audioId = audioId;
	}

	public String getAudioName() {
		return audioName;
	}

	public void setAudioName(String audioName) {
		this.audioName = audioName;
	}

	public String getAudioFileDir() {
		return audioFileDir;
	}

	public void setAudioFileDir(String audioFileDir) {
		this.audioFileDir = audioFileDir;
	}

	public Date getAudioCreatedDate() {
		return audioCreatedDate;
	}

	public void setAudioCreatedDate(Date audioCreatedDate) {
		this.audioCreatedDate = audioCreatedDate;
	}

	public word getWordId() {
		return wordId;
	}

	public void setWordId(word wordId) {
		this.wordId = wordId;
	}

	@Override
	public String toString() {
		return "audio [audioId=" + audioId + ", audioName=" + audioName + ", audioFileDir=" + audioFileDir
				+ ", audioCreatedDate=" + audioCreatedDate + ", wordId=" + wordId + "]";
	}
	
	
	
	
}
