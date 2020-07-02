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
@Table(name = "image")
public class image {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageId")
	private Integer imageId;
	
	@Column(name = "imageName")
	private String imageName;
	  
	@Column(name = "imageFileDir")
	private String imageFileDir;
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "imageCreatedDate")
	private Date imageCreatedDate;
	
	@OneToOne
	@JoinColumn(name = "wordId")
	private word wordId;
	
	public image() {}
	

	public image(String imageName, String imageFileDir, Date imageCreatedDate, word wordId) {
		this.imageName = imageName;
		this.imageFileDir = imageFileDir;
		this.imageCreatedDate = imageCreatedDate;
		this.wordId = wordId;
	}
	
	

	public image(Integer imageId, String imageName, String imageFileDir, Date imageCreatedDate, word wordId) {
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageFileDir = imageFileDir;
		this.imageCreatedDate = imageCreatedDate;
		this.wordId = wordId;
	}


	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageFileDir() {
		return imageFileDir;
	}

	public void setImageFileDir(String imageFileDir) {
		this.imageFileDir = imageFileDir;
	}

	public Date getImageCreatedDate() {
		return imageCreatedDate;
	}

	public void setImageCreatedDate(Date imageCreatedDate) {
		this.imageCreatedDate = imageCreatedDate;
	}

	public word getWordId() {
		return wordId;
	}

	public void setWordId(word wordId) {
		this.wordId = wordId;
	}

	@Override
	public String toString() {
		return "image [imageId=" + imageId + ", imageName=" + imageName + ", imageFileDir=" + imageFileDir
				+ ", imageCreatedDate=" + imageCreatedDate + ", wordId=" + wordId + "]";
	}
	
	
	
}
