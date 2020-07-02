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
@Table(name = "teacher")
public class teacher {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacherId")
	private Integer teacherId;
	
	@Column(name = "teacherName")
	private String teacherName;
	
	@Column(name = "teacherSurname")
	private String teacherSurname;
	
	@Column(name = "teacherYearBirth")
	private Integer teacherYearBirth;
	
	@Column(name = "teacherCity")
	private String teacherCity;
	
	@Column(name = "teacherProfession")
	private String teacherProfession;
	
	@OneToOne
	@JoinColumn(name = "accountTeacherId")
	private account accountTeacherId;
	
	@OneToOne
	@JoinColumn(name = "languageTeacherId")
	private language languageTeacherId;
	
	public teacher()
	{
		
	}
	
	
	public teacher(Integer teacherId, String teacherName, String teacherSurname, Integer teacherYearBirth,
			String teacherCity, String teacherProfession, account accountTeacherId, language languageTeacherId) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherSurname = teacherSurname;
		this.teacherYearBirth = teacherYearBirth;
		this.teacherCity = teacherCity;
		this.teacherProfession = teacherProfession;
		this.accountTeacherId = accountTeacherId;
		this.languageTeacherId = languageTeacherId;
	}


	public teacher(String teacherName, String teacherSurname, Integer teacherYearBirth, String teacherCity,
			String teacherProfession, account accountTeacherId, language languageTeacherId) {
		this.teacherName = teacherName;
		this.teacherSurname = teacherSurname;
		this.teacherYearBirth = teacherYearBirth;
		this.teacherCity = teacherCity;
		this.teacherProfession = teacherProfession;
		this.accountTeacherId = accountTeacherId;
		this.languageTeacherId = languageTeacherId;
	}

	public language getLanguageTeacherId() {
		return languageTeacherId;
	}

	public void setLanguageTeacherId(language languageTeacherId) {
		this.languageTeacherId = languageTeacherId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSurname() {
		return teacherSurname;
	}

	public void setTeacherSurname(String teacherSurname) {
		this.teacherSurname = teacherSurname;
	}

	public Integer getTeacherYearBirth() {
		return teacherYearBirth;
	}

	public void setTeacherYearBirth(Integer teacherYearBirth) {
		this.teacherYearBirth = teacherYearBirth;
	}

	public String getTeacherCity() {
		return teacherCity;
	}

	public void setTeacherCity(String teacherCity) {
		this.teacherCity = teacherCity;
	}

	public String getTeacherProfession() {
		return teacherProfession;
	}

	public void setTeacherProfession(String teacherProfession) {
		this.teacherProfession = teacherProfession;
	}

	public account getAccountTeacherId() {
		return accountTeacherId;
	}

	public void setAccountTeacherId(account accountTeacherId) {
		this.accountTeacherId = accountTeacherId;
	}


	@Override
	public String toString() {
		return "teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherSurname=" + teacherSurname
				+ ", teacherYearBirth=" + teacherYearBirth + ", teacherCity=" + teacherCity + ", teacherProfession="
				+ teacherProfession + ", accountTeacherId=" + accountTeacherId + ", languageTeacherId="
				+ languageTeacherId + "]";
	}

	
	
	
	
	
	
}
