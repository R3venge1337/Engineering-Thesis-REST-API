package engineeringthesis.androidrestapi.child;

import java.util.List;


public interface ChildService {
	
	List<ChildDTO> getAllChild();
	
	ChildDTO saveChild(ChildDTO children);
	
	ChildDTO getOneByName(String name);
	
	ChildDTO getOneById(Integer childId);
	
	ChildDTO updateChild(Integer childId,ChildDTO children);
	
	void deleteChild(Integer childId);
	
	ChildDTO getChildWithAccount(String accountName);
}
