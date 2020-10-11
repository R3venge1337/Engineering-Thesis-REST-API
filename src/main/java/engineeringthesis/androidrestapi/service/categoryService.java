package engineeringthesis.androidrestapi.service;

import java.util.List;
import engineeringthesis.androidrestapi.dto.CategoryDTO;

public interface CategoryService {
	
	List<CategoryDTO> getAllCategories();
	
	List<CategoryDTO> getAllCategoriesByLanguage(String languageName);
	
	CategoryDTO saveCategory(CategoryDTO cat);
	
	CategoryDTO getCategoryByName(String name);
	
	CategoryDTO getCategoryById(Integer categoryId);
	
	CategoryDTO updateCategory(Integer categoryId,CategoryDTO cat);
	
	void deleteCategory(Integer categoryId);
}
