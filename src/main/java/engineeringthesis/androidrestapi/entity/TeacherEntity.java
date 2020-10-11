package engineeringthesis.androidrestapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teacher")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class TeacherEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id_pk")
	private Integer teacherId;
	
	@Column(name = "teacher_name")
	private String teacherName;
	
	@Column(name = "teacher_surname")
	private String teacherSurname;
	
	
	@Column(name = "teacher_year_of_birth")
	private Short teacherYearBirth;
	
	@Column(name = "teacher_city")
	private String teacherCity;
	
	@Column(name = "teacher_profession")
	private String teacherProfession;
	
	@Column(name = "teacher_address")
	private String teacherAddress;
	
	@Column(name = "teacher_zip_code",columnDefinition="char(6)")
	private String teacherZipCode;
	
	@OneToOne
	@JoinColumn(name = "account_id_fk")
	private AccountEntity accountTeacherId;
	
	@OneToOne
	@JoinColumn(name = "language_id_fk")
	private LanguageEntity languageTeacherId;	
}
