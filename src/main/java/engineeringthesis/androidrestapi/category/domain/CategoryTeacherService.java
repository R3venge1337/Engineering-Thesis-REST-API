package engineeringthesis.androidrestapi.category.domain;

import engineeringthesis.androidrestapi.category.CategoryTeacherFacade;
import engineeringthesis.androidrestapi.category.dto.CategoryTeacherDto;
import engineeringthesis.androidrestapi.category.dto.CreateCategoryTeacherForm;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class CategoryTeacherService implements CategoryTeacherFacade {

    private final CategoryTeacherRepository categoryTeacherRepository;

    @Override
    public List<CategoryTeacherDto> getCategoriesTeacher(final UUID uuid) {
        return categoryTeacherRepository.getCategoriesTeacher(uuid)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public CategoryTeacherDto saveCategoryToTeacher(final CreateCategoryTeacherForm teacherCategoryForm) {
        CategoryTeacher categoryTeacher = new CategoryTeacher();

        return mapToDto(categoryTeacherRepository.save(categoryTeacher));
    }

    CategoryTeacherDto mapToDto(final CategoryTeacher categoryTeacher) {
        return new CategoryTeacherDto(categoryTeacher.getUuid(), null, null);
    }
} 
