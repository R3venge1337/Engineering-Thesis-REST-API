package engineeringthesis.androidrestapi.category.domain;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import engineeringthesis.androidrestapi.category.CategoryFacade;
import engineeringthesis.androidrestapi.category.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CategoryService implements CategoryFacade {
	
	
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	@Override
	public List<CategoryDTO> getAllCategories() {
		
		return categoryMapper.mapOfCollection(categoryRepository.findAll());
	}

	@Override
	public List<CategoryDTO> getAllCategoriesByLanguage(String languageName) {
		
		return categoryMapper.mapOfCollection(categoryRepository.getCategoriesByLanguage(languageName));
	}

	@Override
	public CategoryDTO saveCategory(CategoryDTO cat) {
		
		CategoryEntity categoryEntity = categoryMapper.mapOfDTO(cat);
		CategoryEntity savedEntity = categoryRepository.save(categoryEntity);
		 return categoryMapper.mapOfEntity(savedEntity);
	}

	@Override
	public CategoryDTO getCategoryByName(String name) {
		
		return categoryMapper.mapOfEntity(categoryRepository.findByCategoryNazwa(name));
	}

	@Override
	public CategoryDTO getCategoryById(Integer categoryId) {
		
		return categoryMapper.mapOfEntity(categoryRepository.findById(categoryId).get());
	}
	
	@Override
	public CategoryDTO updateCategory(Integer categoryId, CategoryDTO cat) {
		
		Optional<CategoryEntity> categoryEntity = categoryRepository.findById(categoryId);
		CategoryEntity savedEntity = categoryEntity.get();
		savedEntity.setCategoryName(cat.getCategoryName());
		savedEntity.setLanguageId(cat.getLanguageId());
		categoryRepository.save(savedEntity);
		CategoryDTO dto = categoryMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		categoryRepository.deleteById(categoryId);
		
	}


}
