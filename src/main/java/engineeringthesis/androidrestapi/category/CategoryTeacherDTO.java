package engineeringthesis.androidrestapi.category;
import engineeringthesis.androidrestapi.teacher.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class CategoryTeacherDTO {
	
	private Integer categoryTeacherId;
	
	private CategoryEntity categoryId;
	
	private TeacherEntity teacherId;
	
	private boolean isNew;

	private boolean isAccepted;
}
