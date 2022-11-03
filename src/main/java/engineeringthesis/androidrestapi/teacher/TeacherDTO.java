package engineeringthesis.androidrestapi.teacher;



import engineeringthesis.androidrestapi.account.AccountEntity;
import engineeringthesis.androidrestapi.language.LanguageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class TeacherDTO {

	private Integer teacherId;
	
	private String teacherName;
	
	private String teacherSurname;
	
	private Short teacherYearBirth;

	private String teacherCity;
	
	private String teacherProfession;
	
	private LanguageEntity languageTeacherId;
	
	private AccountEntity accountTeacherId;
	
	
}
