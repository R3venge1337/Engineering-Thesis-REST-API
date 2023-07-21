package engineeringthesis.androidrestapi.category.controller;

import engineeringthesis.androidrestapi.category.CategoryFacade;
import engineeringthesis.androidrestapi.category.dto.CategoryDto;
import engineeringthesis.androidrestapi.category.dto.CreateCategoryForm;
import engineeringthesis.androidrestapi.category.dto.UpdateCategoryForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/api/categories")
@RequiredArgsConstructor
class CategoryController {

    private final CategoryFacade categoryService;

    @GetMapping
    List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "/languages/{languageName}")
    List<CategoryDto> getAllCategoriesByLanguage(@PathVariable final String languageName) {
        return categoryService.getAllCategoriesByLanguage(languageName);
    }

    @GetMapping(params = "name")
    CategoryDto getCategoryByName(@RequestParam final String name) {
        return categoryService.getCategoryByName(name);
    }

    @GetMapping(value = "/{uuid}")
    CategoryDto findCategory(@PathVariable final UUID uuid) {
        return categoryService.findCategory(uuid);
    }

    @PostMapping
    CategoryDto saveCategory(@RequestBody final CreateCategoryForm categoryForm) {
        return categoryService.saveCategory(categoryForm);
    }

    @PutMapping(value = "/{uuid}")
    void updateCategory(@PathVariable final UUID uuid, @RequestBody final UpdateCategoryForm categoryForm) {
        categoryService.updateCategory(uuid, categoryForm);
    }

    @DeleteMapping(value = "/{uuid}")
    void deleteCategory(@PathVariable final UUID uuid) {
        categoryService.deleteCategory(uuid);
    }
}
