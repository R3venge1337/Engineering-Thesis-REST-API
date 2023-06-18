package engineeringthesis.androidrestapi.teacher.domain;


import engineeringthesis.androidrestapi.account.domain.Account;
import engineeringthesis.androidrestapi.language.domain.LanguageEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teacher")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
class Teacher {
	
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
	
	@OneToOne
	@JoinColumn(name = "language_id_fk")
	private Language languageTeacherId;
	
	@OneToOne
	@JoinColumn(name = "account_id_fk")
	private Account accountTeacherId;
	
	
}
