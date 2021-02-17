package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import engineeringthesis.androidrestapi.dto.WordDTO;
import engineeringthesis.androidrestapi.entity.WordEntity;
import engineeringthesis.androidrestapi.mapper.WordMapper;
import engineeringthesis.androidrestapi.repository.WordRepository;
import engineeringthesis.androidrestapi.service.WordService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class WordServiceImpl implements WordService{

		private final WordRepository wordRepository;
		private final WordMapper wordMapper;

		@Override
		public List<WordDTO> getAllWords() {
			
			return  wordMapper.mapOfCollection(wordRepository.findAll());
		}

		@Override
		public WordDTO saveWord(WordDTO wordObj) {
			
			WordEntity wordEntity = wordMapper.mapOfDTO(wordObj);
			WordEntity savedEntity = wordRepository.save(wordEntity);
			return wordMapper.mapOfEntity(savedEntity);
		}

		@Override
		public WordDTO getWordByName(String wordName) {
			return  wordMapper.mapOfEntity(wordRepository.getWordByName(wordName));
		}

		@Override
		public WordDTO getWordById(Integer wordId) {
			
			return wordMapper.mapOfEntity(wordRepository.findById(wordId).get());
		}

		@Override
		public void deleteWord(Integer wordId) {
			 
			wordRepository.deleteById(wordId);
		}

		@Override
		public WordDTO updateWord(Integer wordId, WordDTO word) {
			
			Optional<WordEntity> accountEntity = wordRepository.findById(wordId);
			WordEntity savedEntity = accountEntity.get();
			savedEntity.setWordName(word.getWordName());
			wordRepository.save(savedEntity);
			WordDTO dto = wordMapper.mapOfEntity(savedEntity);
			return dto;
		}

		@Override
		public Page<WordDTO> getWordsByCategoryName(String categoryName,Integer page,Integer size) {
			int pageNumber = page != null && page > 0 ? page : 0;
			int sizeNumber = size != null && size > 0 ? size : 4;
			return wordMapper.map(wordRepository.findAllByCategoryId_CategoryName(categoryName,PageRequest.of(pageNumber, sizeNumber)));
		}	
}
