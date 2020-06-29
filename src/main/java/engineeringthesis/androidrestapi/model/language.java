package engineeringthesis.androidrestapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "language")
public class language {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "languageId")
		private Integer languageId;
	
	@Column(name = "languageName")
		private String languageName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	@Column(name = "languageCreatedDate")
		private Date languageCreatedDate;
	
		
		public language(){};
		
		
		public language(String languageName, Date languageCreatedDate) {
			this.languageName = languageName;
			this.languageCreatedDate = languageCreatedDate;
		}
		
		public Integer getLanguageId() {
			return languageId;
		}
		public void setLanguageId(Integer languageId) {
			this.languageId = languageId;
		}
		public String getLanguageName() {
			return languageName;
		}
		public void setLanguageName(String languageName) {
			this.languageName = languageName;
		}
		public Date getLanguageCreatedDate() {
			return languageCreatedDate;
		}
		public void setLanguageCreatedDate(Date languageCreatedDate) {
			this.languageCreatedDate = languageCreatedDate;
		}
		
		@Override
		public String toString() {
			return "language [languageId=" + languageId + ", languageName=" + languageName + ", languageCreatedDate="
					+ languageCreatedDate + "]";
		}
		
		
		
}
