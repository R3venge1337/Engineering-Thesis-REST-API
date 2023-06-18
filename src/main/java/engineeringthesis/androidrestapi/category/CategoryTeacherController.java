package engineeringthesis.androidrestapi.category;

import java.util.List;

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

	private final CategoryTeacherServiceImpl categoryTeacherSerivceImpl;

	@GetMapping(value = "/{teacherId}")
	List<CategoryTeacherDTO> getAllCategoriesByTeacherId(@PathVariable Integer teacherId) {
		return categoryTeacherSerivceImpl.getCategoriesTeacher(teacherId);
	}

	@PostMapping
	CategoryTeacherDTO saveCategoryToTeacher(@RequestBody CategoryTeacherDTO categoryTeacherObj) {
		return categoryTeacherSerivceImpl.saveCategoryToTeacher(categoryTeacherObj);
	}
}
