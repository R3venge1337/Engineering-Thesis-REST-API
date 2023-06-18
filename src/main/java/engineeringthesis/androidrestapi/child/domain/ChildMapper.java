package engineeringthesis.androidrestapi.child.domain;

import engineeringthesis.androidrestapi.child.dto.ChildDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class ChildMapper implements Mapper<ChildDTO, Child> {

	
	@Override
	public ChildDTO mapOfEntity(Child entity) {
		
		ChildDTO childDTO = ChildDTO.builder()
				.childId(entity.getChildId())
				.childName(entity.getChildName())
				.childSurname(entity.getChildSurname())
				.childYearBirth(entity.getChildYearBirth())
				.childCity(entity.getChildCity())
				.accountChildId(entity.getAccountChildId())
				.childQuestUUID(entity.getChildQuestUUID())
				.build();
		
		return childDTO;
	}
	
	@Override
	public Child mapOfDTO(ChildDTO dto) {
		
		Child childEntity = Child.builder()
				.childId(dto.getChildId())
				.childName(dto.getChildName())
				.childSurname(dto.getChildSurname())
				.childYearBirth(dto.getChildYearBirth())
				.childCity(dto.getChildCity())
				.accountChildId(dto.getAccountChildId())
				.childQuestUUID(dto.getChildQuestUUID())
				.build();
		
		return childEntity;
	}

	

}
