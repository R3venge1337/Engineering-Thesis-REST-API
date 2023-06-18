package engineeringthesis.androidrestapi.category;

import engineeringthesis.androidrestapi.category.dto.CategoryTeacherDTO;

import java.util.List;

public interface CategoryTeacherFacade {
	
	List<CategoryTeacherDTO> getCategoriesTeacher(Integer teacherId);
	
	CategoryTeacherDTO saveCategoryToTeacher(CategoryTeacherDTO categoryTeacherObj);
}
