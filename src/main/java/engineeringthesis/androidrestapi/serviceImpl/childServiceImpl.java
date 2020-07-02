package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.child;
import engineeringthesis.androidrestapi.repository.childRepository;
import engineeringthesis.androidrestapi.service.childService;

@Service
@Transactional
public class childServiceImpl implements childService {
	
	@Autowired
	childRepository childRepository;

	@Override
	public List<child> getAllChild() {
		return childRepository.findAll();
	}

	@Override
	public child saveChild(child children) {
		return childRepository.save(children);
	}

	@Override
	public child getOneByName(String name) {
		return null;
	}

	@Override
	public Optional<child> getOneById(Integer childId) {
		return childRepository.findById(childId);
	}

	@Override
	public void deleteChild(Integer childId) {
		childRepository.deleteById(childId);
	}
}
