package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.dto.CategoryTeacherDTO;
import engineeringthesis.androidrestapi.entity.CategoryTeacherEntity;
import engineeringthesis.androidrestapi.mapper.CategoryTeacherMapper;
import engineeringthesis.androidrestapi.repository.CategoryTeacherRepository;
import engineeringthesis.androidrestapi.service.CategoryTeacherService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryTeacherServiceImpl implements CategoryTeacherService {
	
	private final CategoryTeacherRepository categoryTeacherRepository;
	private final CategoryTeacherMapper categoryTeacherMapper;
	
	@Override
	public List<CategoryTeacherDTO> getCategoriesTeacher(Integer teacherId) {
		return categoryTeacherMapper.mapOfCollection(categoryTeacherRepository.getCategoriesTeacher(teacherId));
	}

	@Override
	public CategoryTeacherDTO saveCategoryToTeacher(CategoryTeacherDTO categoryTeacherObj) {
		
		CategoryTeacherEntity categoryTeacherEntity = categoryTeacherMapper.mapOfDTO(categoryTeacherObj);
		CategoryTeacherEntity categoryTeacherEntitySaved = categoryTeacherRepository.save(categoryTeacherEntity);
		return categoryTeacherMapper.mapOfEntity(categoryTeacherEntitySaved);
	}
	
	
} 
