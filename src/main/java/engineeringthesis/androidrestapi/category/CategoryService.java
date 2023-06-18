package engineeringthesis.androidrestapi.category;

import java.util.List;

public interface CategoryService {
	
	List<CategoryDTO> getAllCategories();
	
	List<CategoryDTO> getAllCategoriesByLanguage(String languageName);
	
	CategoryDTO saveCategory(CategoryDTO cat);
	
	CategoryDTO getCategoryByName(String name);
	
	CategoryDTO getCategoryById(Integer categoryId);
	
	CategoryDTO updateCategory(Integer categoryId,CategoryDTO cat);
	
	void deleteCategory(Integer categoryId);
}