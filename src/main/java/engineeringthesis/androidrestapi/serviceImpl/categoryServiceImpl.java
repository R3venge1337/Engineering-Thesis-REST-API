package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.category;
import engineeringthesis.androidrestapi.repository.categoryRepository;
import engineeringthesis.androidrestapi.service.categoryService;

@Service
@Transactional
public class categoryServiceImpl implements categoryService {
	
	@Autowired
	categoryRepository categoryRepo;
	
	@Override
	public List<category> getAllCategories() {
		
		return categoryRepo.findAll();
	}

	@Override
	public List<category> getAllCategoriesByLanguage(String languageName) {
		
		return categoryRepo.getCategoriesByLanguage(languageName);
	}

	@Override
	public category saveCategory(category cat) {
		
		return categoryRepo.save(cat);
	}

	@Override
	public category getCategoryByName(String name) {
		
		return categoryRepo.findByCategoryNazwa(name);
	}

	@Override
	public Optional<category> getCategoryById(Integer categoryId) {
		
		return categoryRepo.findById(categoryId);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		categoryRepo.deleteById(categoryId);
		
	}

}
