package engineeringthesis.androidrestapi.category.controller;

import engineeringthesis.androidrestapi.category.CategoryFacade;
import engineeringthesis.androidrestapi.category.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/categories")
@RequiredArgsConstructor
class CategoryController {

    private final CategoryFacade categoryService;

    @GetMapping
    List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "/languages/{languageName}")
    List<CategoryDTO> getAllCategoriesByLanguage(@PathVariable String languageName) {
        return categoryService.getAllCategoriesByLanguage(languageName);
    }

    @GetMapping(params = "categoryName")
    CategoryDTO getCategoryByName(@RequestParam("categoryName") String categoryName) {
        return categoryService.getCategoryByName(categoryName);
    }

    @GetMapping(value = "/{categoryId}")
    CategoryDTO getCategoryById(@PathVariable Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping
    CategoryDTO saveCategory(@RequestBody CategoryDTO cat) {
        return categoryService.saveCategory(cat);
    }

    @PutMapping(value = "/{categoryId}")
    CategoryDTO updateCategory(@RequestBody CategoryDTO cat,
                               @PathVariable Integer categoryId) {
        return categoryService.updateCategory(categoryId, cat);
    }

    @DeleteMapping(value = "/{categoryId}")
    void deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
