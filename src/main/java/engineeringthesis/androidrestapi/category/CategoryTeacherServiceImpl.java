package engineeringthesis.androidrestapi.category;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
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
