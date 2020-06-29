package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.language;
import engineeringthesis.androidrestapi.repository.languageRepository;
import engineeringthesis.androidrestapi.service.languageService;

@Service
@Transactional
public class languageServiceImpl implements languageService {

	@Autowired
	languageRepository languageRepo;
	
	@Override
	public List<language> getAllLanguage() {
		return languageRepo.findAll();
	}

	@Override
	public language saveLanguage(language lang) {
		return languageRepo.save(lang);
	}

	@Override
	public language getOneByName(String name) {
		return languageRepo.findByLanguageName(name);
	}

	@Override
	public Optional<language> getOneById(Integer languageId) {
		return languageRepo.findById(languageId);
	}

	@Override
	public void deleteLanguage(Integer languageId) {
		languageRepo.deleteById(languageId);
		
	}

}
