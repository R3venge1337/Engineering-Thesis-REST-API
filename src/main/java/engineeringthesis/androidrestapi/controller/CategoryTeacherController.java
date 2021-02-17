package engineeringthesis.androidrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.dto.CategoryTeacherDTO;
import engineeringthesis.androidrestapi.serviceImpl.CategoryTeacherServiceImpl;

@RestController
@RequestMapping(value = "/api/categories/teachers")
public class CategoryTeacherController {
	
	@Autowired
	CategoryTeacherServiceImpl categoryTeacherSerivceImpl;
	
	@GetMapping(value = "/{teacherId}")
	 public  List<CategoryTeacherDTO> getAllCategoriesByTeacherId(@PathVariable Integer teacherId)
	  {
			return categoryTeacherSerivceImpl.getCategoriesTeacher(teacherId);
	  }
	
	@PostMapping
    CategoryTeacherDTO saveCategoryToTeacher(@RequestBody CategoryTeacherDTO categoryTeacherObj)
    {
    	return categoryTeacherSerivceImpl.saveCategoryToTeacher(categoryTeacherObj);
    }
}
