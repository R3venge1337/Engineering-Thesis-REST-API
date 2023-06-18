package engineeringthesis.androidrestapi.category.domain;

import java.util.List;


import engineeringthesis.androidrestapi.category.CategoryTeacherFacade;
import engineeringthesis.androidrestapi.category.dto.CategoryTeacherDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CategoryTeacherService implements CategoryTeacherFacade {
	
	private final CategoryTeacherRepository categoryTeacherRepository;
	private final CategoryTeacherMapper categoryTeacherMapper;
	
	@Override
	public List<CategoryTeacherDTO> getCategoriesTeacher(Integer teacherId) {
		return categoryTeacherMapper.mapOfCollection(categoryTeacherRepository.getCategoriesTeacher(teacherId));
	}

	@Override
	public CategoryTeacherDTO saveCategoryToTeacher(CategoryTeacherDTO categoryTeacherObj) {
		
		CategoryTeacher categoryTeacherEntity = categoryTeacherMapper.mapOfDTO(categoryTeacherObj);
		CategoryTeacher categoryTeacherEntitySaved = categoryTeacherRepository.save(categoryTeacherEntity);
		return categoryTeacherMapper.mapOfEntity(categoryTeacherEntitySaved);
	}
	
	
} 
