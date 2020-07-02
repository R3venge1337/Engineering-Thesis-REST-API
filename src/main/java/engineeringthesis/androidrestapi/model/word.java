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
@Table(name = "word")
public class word {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wordId")
	private Integer wordId;
	
	@Column(name = "wordName")
	private String wordName;
	
	@OneToOne
	@JoinColumn(name = "categoryId")
	private category categoryId;
	
	@OneToOne
	@JoinColumn(name = "languageId")
	private language languageId;
	
	public word() {}
	
	public word(String wordName, category categoryId, language languageId) {
		this.wordName = wordName;
		this.categoryId = categoryId;
		this.languageId = languageId;
	}
	public word(Integer wordId, String wordName, category categoryId, language languageId) {
		this.wordId = wordId;
		this.wordName = wordName;
		this.categoryId = categoryId;
		this.languageId = languageId;
	}

	public Integer getWordId() {
		return wordId;
	}

	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}

	public String getWordName() {
		return wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(category categoryId) {
		this.categoryId = categoryId;
	}

	public language getLanguageId() {
		return languageId;
	}

	public void setLanguageId(language languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		return "word [wordId=" + wordId + ", wordName=" + wordName + ", categoryId=" + categoryId + ", languageId="
				+ languageId + "]";
	}
	
	


	
	
	
}
