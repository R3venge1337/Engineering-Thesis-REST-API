package engineeringthesis.androidrestapi.child;

import engineeringthesis.androidrestapi.child.dto.ChildDto;
import engineeringthesis.androidrestapi.child.dto.CreateChildForm;

import java.util.List;
import java.util.UUID;


public interface ChildFacade {
	
	List<ChildDto> getAllChild();
	
	ChildDto saveChild(final CreateChildForm childForm);
	
	ChildDto getOneByName(final String name);

	ChildDto updateChild(final UUID uuid, final CreateChildForm childForm);
	
	void deleteChild(final UUID uuid);
	
	ChildDto getChildWithAccount(final UUID uuid, final String accountName);
}
