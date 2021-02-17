package engineeringthesis.androidrestapi.dto;



import engineeringthesis.androidrestapi.entity.AccountEntity;
import engineeringthesis.androidrestapi.entity.LanguageEntity;
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
