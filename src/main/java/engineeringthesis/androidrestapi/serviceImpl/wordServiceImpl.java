package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.word;
import engineeringthesis.androidrestapi.repository.wordRepository;
import engineeringthesis.androidrestapi.service.wordService;

@Service
@Transactional
public class wordServiceImpl implements wordService{

		@Autowired
		wordRepository wordRepo;

		@Override
		public List<word> getAllWords() {
			return  wordRepo.findAll();
		}

		@Override
		public word saveWord(word wordObj) {
			return  wordRepo.save(wordObj);
		}

		@Override
		public word getOneByName(String name) {
			return null;
		}

		@Override
		public Optional<word> getOneById(Integer wordId) {
			return  wordRepo.findById(wordId);
		}

		@Override
		public void deleteWord(Integer wordId) {
			 wordRepo.deleteById(wordId);
			
		}
}
