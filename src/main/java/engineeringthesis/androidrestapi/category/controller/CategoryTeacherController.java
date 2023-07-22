package engineeringthesis.androidrestapi.category.controller;

import java.util.List;
import java.util.UUID;

import engineeringthesis.androidrestapi.category.CategoryTeacherFacade;
import engineeringthesis.androidrestapi.category.dto.CategoryTeacherDto;
import engineeringthesis.androidrestapi.category.dto.CreateCategoryTeacherForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/categories/teachers")
@RequiredArgsConstructor
class CategoryTeacherController {

	private final CategoryTeacherFacade categoryTeacherFacade;

	@GetMapping(value = "/{uuid}")
	List<CategoryTeacherDto> getAllCategoriesByTeacherId(@PathVariable final UUID uuid) {
		return categoryTeacherFacade.getCategoriesTeacher(uuid);
	}

	@PostMapping
    CategoryTeacherDto saveCategoryToTeacher(@RequestBody final CreateCategoryTeacherForm categoryTeacherForm) {
		return categoryTeacherFacade.saveCategoryToTeacher(categoryTeacherForm);
	}
}
