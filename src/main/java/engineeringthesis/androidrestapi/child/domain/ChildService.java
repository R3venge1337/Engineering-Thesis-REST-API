package engineeringthesis.androidrestapi.child.domain;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import engineeringthesis.androidrestapi.child.ChildFacade;
import engineeringthesis.androidrestapi.child.dto.ChildDTO;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ChildService implements ChildFacade {
	
	
	private final ChildRepository childRepository;
	private final ChildMapper childMapper;

	@Override
	public List<ChildDTO> getAllChild() {
		return childMapper.mapOfCollection(childRepository.findAll());
	}

	@Override
	public ChildDTO saveChild(ChildDTO child) {
		
		//System.out.println("Przed mapowaniem: "+ child);
		Child childEntity = childMapper.mapOfDTO(child);
		//System.out.println(child);
		Child savedEntity = childRepository.save(childEntity);
		return childMapper.mapOfEntity(savedEntity);
	}

	@Override
	public ChildDTO getOneByName(String name) {
		return null;
	}

	@Override
	public ChildDTO getOneById(Integer childId) {
		return	childMapper.mapOfEntity(childRepository.findById(childId).get());
	}
	
	@Override
	public ChildDTO updateChild(Integer childId, ChildDTO child) {
		
		Optional<Child> childEntity = childRepository.findById(childId);
		Child savedEntity = childEntity.get();
		savedEntity.setChildName(child.getChildName());
		savedEntity.setChildSurname(child.getChildSurname());
		savedEntity.setChildCity(child.getChildCity());
		savedEntity.setChildYearBirth(child.getChildYearBirth());
		savedEntity.setAccountChildId(child.getAccountChildId());
		childRepository.save(savedEntity);
		ChildDTO dto = childMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteChild(Integer childId) {
		childRepository.deleteById(childId);
	}

	@Override
	public ChildDTO getChildWithAccount(String accountName) {
		
		return childMapper.mapOfEntity(childRepository.getChildWithAccount(accountName));
	}

	
}
