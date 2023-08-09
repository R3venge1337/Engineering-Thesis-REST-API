package engineeringthesis.androidrestapi.category.controller;

import engineeringthesis.androidrestapi.category.CategoryFacade;
import engineeringthesis.androidrestapi.category.dto.CategoryDto;
import engineeringthesis.androidrestapi.category.dto.CategoryFilterForm;
import engineeringthesis.androidrestapi.category.dto.CreateCategoryForm;
import engineeringthesis.androidrestapi.category.dto.UpdateCategoryForm;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static engineeringthesis.androidrestapi.category.controller.CategoryController.Routes.ROOT;
import static engineeringthesis.androidrestapi.category.controller.CategoryController.Routes.ROOT_UUID;


@RestController
@RequiredArgsConstructor
class CategoryController {

    private final CategoryFacade categoryService;

    static final class Routes {
        static final String ROOT = "/categories";

        static final String ROOT_UUID = ROOT + "/{uuid}";
    }

    @GetMapping(ROOT)
    PageDto<CategoryDto> findAllCategories(final CategoryFilterForm filterForm, final PageableRequest pageableRequest) {
        return categoryService.findAllCategories(filterForm, pageableRequest);
    }

    @GetMapping(ROOT_UUID)
    CategoryDto findCategory(@PathVariable final UUID uuid) {
        return categoryService.findCategory(uuid);
    }

    @PostMapping
    UuidDto saveCategory(@RequestBody final CreateCategoryForm categoryForm) {
        return categoryService.saveCategory(categoryForm);
    }

    @PutMapping(ROOT_UUID)
    void updateCategory(@PathVariable final UUID uuid, @RequestBody final UpdateCategoryForm categoryForm) {
        categoryService.updateCategory(uuid, categoryForm);
    }

    @DeleteMapping(ROOT_UUID)
    void deleteCategory(@PathVariable final UUID uuid) {
        categoryService.deleteCategory(uuid);
    }
}
