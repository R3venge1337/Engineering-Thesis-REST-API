package engineeringthesis.androidrestapi.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.dto.LanguageDTO;
import engineeringthesis.androidrestapi.entity.LanguageEntity;
import engineeringthesis.androidrestapi.mapper.LanguageMapper;
import engineeringthesis.androidrestapi.repository.LanguageRepository;
import engineeringthesis.androidrestapi.service.LanguageService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

	private final LanguageRepository languageRepository;
	private final LanguageMapper languageMapper;
	
	@Override
	public List<LanguageDTO> getAllLanguage() {
		
		return languageMapper.mapOfCollection(languageRepository.findAll());
	}

	@Override
	public LanguageDTO saveLanguage(LanguageDTO lang) {
		
		
		LanguageEntity languageEntity = languageMapper.mapOfDTO(lang);
		languageEntity.setLanguageCreatedDate(LocalDateTime.now());
		LanguageEntity savedEntity = languageRepository.save(languageEntity);
		 return languageMapper.mapOfEntity(savedEntity);
	}

	@Override
	public LanguageDTO getOneByName(String name) {
		
		return languageMapper.mapOfEntity(languageRepository.findByLanguageName(name));
	}

	@Override
	public LanguageDTO getOneById(Integer languageId) {
		
		return languageMapper.mapOfEntity(languageRepository.findById(languageId).get());
	}

	@Override
	public void deleteLanguage(Integer languageId) {
		
		languageRepository.deleteById(languageId);	
	}

	@Override
	public LanguageDTO updateLanguage(Integer languageId,LanguageDTO lang) {
		Optional<LanguageEntity> languageEntity = languageRepository.findById(languageId);
		LanguageEntity savedEntity = languageEntity.get();
		savedEntity.setLanguageName(lang.getLanguageName());
		//savedEntity.setLanguageImageIcon(lang.getLanguageImageIcon());
		savedEntity.setLanguageCreatedDate(lang.getLanguageCreatedDate());
		languageRepository.save(savedEntity);
		LanguageDTO dto = languageMapper.mapOfEntity(savedEntity);
		return dto;
	}

}
