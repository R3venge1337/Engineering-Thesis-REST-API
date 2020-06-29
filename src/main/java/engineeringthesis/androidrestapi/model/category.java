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
@Table(name = "category")
public class category {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
	private Integer categoryId;
	@Column(name = "categoryName")
	private String categoryName;
	@OneToOne
	@JoinColumn(name = "languageId")
	private language languageId;
	
	
	
	
	public category() {}
	
	public category(String categoryName, language languageId) {
		this.categoryName = categoryName;
		this.languageId = languageId;
	}
	
	public category(Integer categoryId, String categoryName, language languageId) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.languageId = languageId;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public language getLanguageId() {
		return languageId;
	}
	public void setLanguageId(language languageId) {
		this.languageId = languageId;
	}
	
	@Override
	public String toString() {
		return "category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", languageId=" + languageId
				+ "]";
	}
	
	
	
	
}
