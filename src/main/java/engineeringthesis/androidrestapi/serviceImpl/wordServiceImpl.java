package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
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
		public WordDTO getOneByName(String name) {
			return null;
		}

		@Override
		public WordDTO getOneById(Integer wordId) {
			
			return  wordMapper.mapOfEntity(wordRepository.findById(wordId).get());
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
}
