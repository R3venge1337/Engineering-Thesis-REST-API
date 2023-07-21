package engineeringthesis.androidrestapi.category;

import engineeringthesis.androidrestapi.category.dto.CategoryDto;
import engineeringthesis.androidrestapi.category.dto.CreateCategoryForm;
import engineeringthesis.androidrestapi.category.dto.UpdateCategoryForm;

import java.util.List;
import java.util.UUID;

public interface CategoryFacade {
	
	List<CategoryDto> getAllCategories();
	
	List<CategoryDto> getAllCategoriesByLanguage(final String languageName);
	
	CategoryDto saveCategory(final CreateCategoryForm categoryForm);
	
	CategoryDto getCategoryByName(final String name);
	
	CategoryDto findCategory(final UUID uuid);
	
	void updateCategory(final UUID uuid, final UpdateCategoryForm categoryForm);
	
	void deleteCategory(final UUID uuid);
}
