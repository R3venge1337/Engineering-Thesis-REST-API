package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.category;
import engineeringthesis.androidrestapi.serviceImpl.categoryServiceImpl;


@RestController
public class categoryController {

    @Autowired
    private categoryServiceImpl categoryService;
    
    //@GetMapping
    @RequestMapping(value = {"/categories"}, method = RequestMethod.GET)
    List<category> getAllCategories()
    {
		return categoryService.getAllCategories();
    }
    
   // @GetMapping
    @RequestMapping( value="/categories/{languageName}",method = RequestMethod.GET)
    List<category> getAllCategoriesByLanguage(@PathVariable String languageName )
    {
		return categoryService.getAllCategoriesByLanguage(languageName);
    }
    
   // @GetMapping
    @RequestMapping(value="/category/{languageName}",method = RequestMethod.GET)
    category getCategoryByName(@PathVariable String languageName )
    {
		return categoryService.getCategoryByName(languageName);
    }
    
    //@GetMapping
    @RequestMapping(value="/category/{categoryId}",method=RequestMethod.GET)
    Optional<category> getCategoryById(@PathVariable Integer categoryId )
    {
		return categoryService.getCategoryById(categoryId);
    }
    //@PostMapping
    @RequestMapping(value="/category",method = RequestMethod.POST)
    category saveCategory(@ModelAttribute category cat)
    {
    	return categoryService.saveCategory(cat);
    }
    @PutMapping
    @RequestMapping(value="/category",method = RequestMethod.PUT)
    category updateCategory(@ModelAttribute category cat)
    {
    	return categoryService.saveCategory(cat);
    }
    @DeleteMapping
    @RequestMapping(value="/category/{id}",method = RequestMethod.DELETE)
    void deleteCategory(@PathVariable Integer id)
    {
    	categoryService.deleteCategory(id);
    }
}
