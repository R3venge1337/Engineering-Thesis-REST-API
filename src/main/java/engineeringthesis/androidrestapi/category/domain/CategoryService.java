package engineeringthesis.androidrestapi.category.domain;

import engineeringthesis.androidrestapi.category.CategoryFacade;
import engineeringthesis.androidrestapi.category.dto.CategoryDto;
import engineeringthesis.androidrestapi.category.dto.CreateCategoryForm;
import engineeringthesis.androidrestapi.category.dto.UpdateCategoryForm;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class CategoryService implements CategoryFacade {


    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<CategoryDto> getAllCategoriesByLanguage(final String languageName) {
        return categoryRepository.getCategoriesByLanguage(languageName).stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public CategoryDto saveCategory(final CreateCategoryForm categoryForm) {
        Category categoryEntity = new Category();
        categoryEntity.setName(categoryForm.name());

        return mapToDto(categoryRepository.save(categoryEntity));
    }

    @Override
    public CategoryDto getCategoryByName(final String name) {
        return mapToDto(categoryRepository.findByCategoryName(name));
    }

    public CategoryDto findCategory(final UUID uuid) {
        return (categoryRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException("")));
    }

    @Override
    @Transactional
    public void updateCategory(final UUID uuid, final UpdateCategoryForm categoryForm) {
        Category category = categoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

        category.setName(categoryForm.name());
    }

    @Override
    @Transactional
    public void deleteCategory(final UUID uuid) {
        categoryRepository.deleteByUuid(uuid);
    }

    CategoryDto mapToDto(final Category category) {
        return new CategoryDto(category.getUuid(), category.getName(),null);
    }

}
