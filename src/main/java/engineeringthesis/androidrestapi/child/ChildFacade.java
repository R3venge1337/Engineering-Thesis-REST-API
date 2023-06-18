package engineeringthesis.androidrestapi.child;

import engineeringthesis.androidrestapi.child.dto.ChildDTO;

import java.util.List;


public interface ChildFacade {
	
	List<ChildDTO> getAllChild();
	
	ChildDTO saveChild(ChildDTO children);
	
	ChildDTO getOneByName(String name);
	
	ChildDTO getOneById(Integer childId);
	
	ChildDTO updateChild(Integer childId,ChildDTO children);
	
	void deleteChild(Integer childId);
	
	ChildDTO getChildWithAccount(String accountName);
}
