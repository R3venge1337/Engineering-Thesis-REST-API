package engineeringthesis.androidrestapi.category;

import engineeringthesis.androidrestapi.category.dto.CategoryTeacherDto;
import engineeringthesis.androidrestapi.category.dto.CreateCategoryTeacherForm;

import java.util.List;
import java.util.UUID;

public interface CategoryTeacherFacade {
	
	List<CategoryTeacherDto> getCategoriesTeacher(final UUID uuid);
	
	CategoryTeacherDto saveCategoryToTeacher(final CreateCategoryTeacherForm categoryTeacherForm);
}
