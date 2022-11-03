package engineeringthesis.androidrestapi.category;

import java.util.List;

public interface CategoryTeacherService {
	
	List<CategoryTeacherDTO> getCategoriesTeacher(Integer teacherId);
	
	CategoryTeacherDTO saveCategoryToTeacher(CategoryTeacherDTO categoryTeacherObj);
}
