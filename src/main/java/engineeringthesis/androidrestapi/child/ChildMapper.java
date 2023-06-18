package engineeringthesis.androidrestapi.child;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.util.Mapper;

@Component
public class ChildMapper implements Mapper<ChildDTO,ChildEntity> {

	
	@Override
	public ChildDTO mapOfEntity(ChildEntity entity) {
		
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
	public ChildEntity mapOfDTO(ChildDTO dto) {
		
		ChildEntity childEntity = ChildEntity.builder()
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
