package engineeringthesis.androidrestapi.category.domain;

import engineeringthesis.androidrestapi.category.dto.CategoryTeacherDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class CategoryTeacherMapper implements Mapper<CategoryTeacherDTO, CategoryTeacher> {

	@Override
	public CategoryTeacherDTO mapOfEntity(CategoryTeacher entity) {
		
		CategoryTeacherDTO categoryTeacherDTO = CategoryTeacherDTO.builder()
				.categoryTeacherId(entity.getCategoryTeacherId())
				.categoryId(entity.getCategoryId())
				.teacherId(entity.getTeacherId())
				.isNew(entity.isNew())
				.isAccepted(entity.isAccepted())
				.build();
		return categoryTeacherDTO;
	}

	@Override
	public CategoryTeacher mapOfDTO(CategoryTeacherDTO dto) {
		
		CategoryTeacher categoryTeacherEntity = CategoryTeacher.builder()
				.categoryTeacherId(dto.getCategoryTeacherId())
				.categoryId(dto.getCategoryId())
				.teacherId(dto.getTeacherId())
				.isNew(dto.isNew())
				.isAccepted(dto.isAccepted())
				.build();
		return categoryTeacherEntity;
	}

}
