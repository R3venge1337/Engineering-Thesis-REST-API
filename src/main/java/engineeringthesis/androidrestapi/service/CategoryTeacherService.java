package engineeringthesis.androidrestapi.service;

import java.util.List;


import engineeringthesis.androidrestapi.dto.CategoryTeacherDTO;

public interface CategoryTeacherService {
	
	List<CategoryTeacherDTO> getCategoriesTeacher(Integer teacherId);
	
	CategoryTeacherDTO saveCategoryToTeacher(CategoryTeacherDTO categoryTeacherObj);
}
