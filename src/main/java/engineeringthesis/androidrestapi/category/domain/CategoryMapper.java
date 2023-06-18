package engineeringthesis.androidrestapi.category.domain;

import engineeringthesis.androidrestapi.category.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class CategoryMapper implements Mapper<CategoryDTO, Category> {

	@Override
	public CategoryDTO mapOfEntity(Category entity) {
		
		CategoryDTO categoryDTO = CategoryDTO.builder()
				.categoryId(entity.getCategoryId())
				.categoryName(entity.getCategoryName())
				.languageId(entity.getLanguageId())
				.isNew(entity.isNew())
				.isAccepted(entity.isAccepted())
				.build();
			
		return categoryDTO;
	}

	@Override
	public Category mapOfDTO(CategoryDTO dto) {
		
		Category categoryEntity = Category.builder()
				.categoryId(dto.getCategoryId())
				.categoryName(dto.getCategoryName())
				.languageId(dto.getLanguageId())
				.isNew(dto.isNew())
				.isAccepted(dto.isAccepted())
				.build();
		
		return categoryEntity;
	}

}