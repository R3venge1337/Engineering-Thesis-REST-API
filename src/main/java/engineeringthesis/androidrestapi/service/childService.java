package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.child;


public interface childService {
	
	List<child> getAllChild();
	
	child saveChild(child children);
	
	child getOneByName(String name);
	
	Optional<child> getOneById(Integer childId);
	
	void deleteChild(Integer childId);
}
