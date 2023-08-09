package engineeringthesis.androidrestapi.category;

import engineeringthesis.androidrestapi.category.dto.CategoryDto;
import engineeringthesis.androidrestapi.category.dto.CategoryFilterForm;
import engineeringthesis.androidrestapi.category.dto.CreateCategoryForm;
import engineeringthesis.androidrestapi.category.dto.UpdateCategoryForm;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;

import java.util.UUID;

public interface CategoryFacade {

    PageDto<CategoryDto> findAllCategories(final CategoryFilterForm filterForm, final PageableRequest pageableRequest);

    UuidDto saveCategory(final CreateCategoryForm categoryForm);

    CategoryDto findCategory(final UUID uuid);

    void updateCategory(final UUID uuid, final UpdateCategoryForm categoryForm);

    void deleteCategory(final UUID uuid);
}
