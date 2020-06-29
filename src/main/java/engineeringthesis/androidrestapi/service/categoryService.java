package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.category;

public interface categoryService {
	
	List<category> getAllCategories();
	
	List<category> getAllCategoriesByLanguage(String languageName);
	
	category saveCategory(category cat);
	
	category getCategoryByName(String name);
	
	Optional<category> getCategoryById(Integer categoryId);
	
	void deleteCategory(Integer categoryId);
}
