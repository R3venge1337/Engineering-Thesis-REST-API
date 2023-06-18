package engineeringthesis.androidrestapi.category;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value = "/api/categories")
@RequiredArgsConstructor
class CategoryController {

    private final CategoryServiceImpl categoryService;
    
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
    
    @GetMapping(params="categoryName")
    CategoryDTO getCategoryByName(@RequestParam("categoryName") String categoryName )
    {
		return categoryService.getCategoryByName(categoryName);
    }
    
    @GetMapping(value = "/{categoryId}")
    CategoryDTO getCategoryById(@PathVariable Integer categoryId )
    {
		return categoryService.getCategoryById(categoryId);
    }
    
    @PostMapping
    CategoryDTO saveCategory(@RequestBody CategoryDTO cat)
    {
    	return categoryService.saveCategory(cat);
    }
    
    @PutMapping(value = "/{categoryId}")
    CategoryDTO updateCategory(@RequestBody CategoryDTO cat,
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
