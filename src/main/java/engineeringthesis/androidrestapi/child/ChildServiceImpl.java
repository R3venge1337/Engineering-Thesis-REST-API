package engineeringthesis.androidrestapi.child;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ChildServiceImpl implements ChildService {
	
	
	private final ChildRepository childRepository;
	private final ChildMapper childMapper;

	@Override
	public List<ChildDTO> getAllChild() {
		return childMapper.mapOfCollection(childRepository.findAll());
	}

	@Override
	public ChildDTO saveChild(ChildDTO child) {
		
		//System.out.println("Przed mapowaniem: "+ child);
		ChildEntity childEntity = childMapper.mapOfDTO(child);
		//System.out.println(child);
		ChildEntity savedEntity = childRepository.save(childEntity);
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
		
		Optional<ChildEntity> childEntity = childRepository.findById(childId);
		ChildEntity savedEntity = childEntity.get();
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
