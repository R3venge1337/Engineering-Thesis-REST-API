package engineeringthesis.androidrestapi.category.controller;

import java.util.List;

import engineeringthesis.androidrestapi.category.CategoryTeacherFacade;
import engineeringthesis.androidrestapi.category.dto.CategoryTeacherDTO;
import engineeringthesis.androidrestapi.category.domain.CategoryTeacherServiceImpl;
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

	private final CategoryTeacherFacade categoryTeacherSerivce;

	@GetMapping(value = "/{teacherId}")
	List<CategoryTeacherDTO> getAllCategoriesByTeacherId(@PathVariable Integer teacherId) {
		return categoryTeacherSerivce.getCategoriesTeacher(teacherId);
	}

	@PostMapping
	CategoryTeacherDTO saveCategoryToTeacher(@RequestBody CategoryTeacherDTO categoryTeacherObj) {
		return categoryTeacherSerivce.saveCategoryToTeacher(categoryTeacherObj);
	}
}
