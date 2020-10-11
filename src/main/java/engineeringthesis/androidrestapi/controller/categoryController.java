package engineeringthesis.androidrestapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import engineeringthesis.androidrestapi.dto.CategoryDTO;
import engineeringthesis.androidrestapi.serviceImpl.CategoryServiceImpl;


@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;
    
    @GetMapping
    List<CategoryDTO> getAllCategories()
    {
		return categoryService.getAllCategories();
    }
    
    @GetMapping(value = "/languages/{languageName}")
    List<CategoryDTO> getAllCategoriesByLanguage(@PathVariable String languageName )
    {
		return categoryService.getAllCategoriesByLanguage(languageName);
    }
    
    @GetMapping(value = "/{categoryName}")
    CategoryDTO getCategoryByName(@PathVariable String categoryName )
    {
		return categoryService.getCategoryByName(categoryName);
    }
    
    @GetMapping(value = "/{categoryId}")
    CategoryDTO getCategoryById(@PathVariable Integer categoryId )
    {
		return categoryService.getCategoryById(categoryId);
    }
    
    @PostMapping
    CategoryDTO saveCategory(@ModelAttribute CategoryDTO cat)
    {
    	return categoryService.saveCategory(cat);
    }
    
    @PutMapping(value = "/{categoryId}")
    CategoryDTO updateCategory(@ModelAttribute CategoryDTO cat,
    		@PathVariable Integer categoryId)
    {
    	return categoryService.updateCategory(categoryId,cat);
    }
    
    @DeleteMapping(value = "/{categoryId}")
    void deleteCategory(@PathVariable Integer categoryId)
    {
    	categoryService.deleteCategory(categoryId);
    }
}
