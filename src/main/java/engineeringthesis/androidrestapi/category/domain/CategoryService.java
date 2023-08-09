package engineeringthesis.androidrestapi.category.domain;

import engineeringthesis.androidrestapi.category.CategoryFacade;
import engineeringthesis.androidrestapi.category.dto.CategoryDto;
import engineeringthesis.androidrestapi.category.dto.CategoryFilterForm;
import engineeringthesis.androidrestapi.category.dto.CreateCategoryForm;
import engineeringthesis.androidrestapi.category.dto.UpdateCategoryForm;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import engineeringthesis.androidrestapi.language.dto.LanguageDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.UUID;

@RequiredArgsConstructor
class CategoryService implements CategoryFacade {


    private final CategoryRepository categoryRepository;

    @Override
    public PageDto<CategoryDto> findAllCategories(final CategoryFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final CategorySpecification specification = new CategorySpecification(filterForm);
        final Page<CategoryDto> categories = categoryRepository.findAll(specification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(categories);
    }

    @Override
    @Transactional
    public UuidDto saveCategory(final CreateCategoryForm categoryForm) {
        final Category category = new Category();
        category.setName(categoryForm.name());
        category.setIsNew(true);
        category.setIsAccepted(false);

        return new UuidDto(categoryRepository.save(category).getUuid());
    }

    public CategoryDto findCategory(final UUID uuid) {
        return (categoryRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException("")));
    }

    @Override
    @Transactional
    public void updateCategory(final UUID uuid, final UpdateCategoryForm updateForm) {
        DtoValidator.validate(updateForm);

        Category category = categoryRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

        category.setName(updateForm.name());
    }

    @Override
    @Transactional
    public void deleteCategory(final UUID uuid) {
        categoryRepository.deleteByUuid(uuid);
    }

    CategoryDto mapToDto(final Category category) {
        return new CategoryDto(category.getUuid(), category.getName(), new LanguageDto(category.getLanguage().getUuid(), category.getLanguage().getName(), category.getLanguage().getCreatedDate()));
    }
}
