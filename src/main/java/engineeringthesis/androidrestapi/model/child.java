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
@Table(name = "child")
public class child {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "childId")
	private Integer childId;
	
	@Column(name = "childName")
	private String childName;
	
	@Column(name = "childSurname")
	private String childSurname;
	
	@Column(name = "childYearBirth")
	private Integer childYearBirth;
	
	@Column(name = "childCity")
	private String childCity;
	
	@OneToOne
	@JoinColumn(name = "accountChildId")
	private account accountChildId;
	
	
	

	public child() {}
	
	public child( String childName, String childPassword, Integer childYearBirth, String childCity,
			account accountChildId) {
		this.childName = childName;
		this.childSurname = childPassword;
		this.childYearBirth = childYearBirth;
		this.childCity = childCity;
		this.accountChildId = accountChildId;
	}

	public child(Integer childId, String childName, String childPassword, Integer childYearBirth, String childCity,
			account accountChildId) {
		this.childId = childId;
		this.childName = childName;
		this.childSurname = childPassword;
		this.childYearBirth = childYearBirth;
		this.childCity = childCity;
		this.accountChildId = accountChildId;
	}

	public Integer getChildId() {
		return childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getChildSurname() {
		return childSurname;
	}

	public void setChildSurname(String childSurname) {
		this.childSurname = childSurname;
	}

	public Integer getChildYearBirth() {
		return childYearBirth;
	}

	public void setChildYearBirth(Integer childYearBirth) {
		this.childYearBirth = childYearBirth;
	}

	public String getChildCity() {
		return childCity;
	}

	public void setChildCity(String childCity) {
		this.childCity = childCity;
	}

	public account getAccountChildId() {
		return accountChildId;
	}

	public void setAccountChildId(account accountChildId) {
		this.accountChildId = accountChildId;
	}

	@Override
	public String toString() {
		return "child [childId=" + childId + ", childName=" + childName + ", childSurname=" + childSurname
				+ ", childYearBirth=" + childYearBirth + ", childCity=" + childCity + ", accountChildId="
				+ accountChildId + "]";
	}
	
	
	
	
	
	
}
