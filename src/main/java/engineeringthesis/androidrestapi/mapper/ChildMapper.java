package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.ChildDTO;
import engineeringthesis.androidrestapi.entity.ChildEntity;

@Component
public class ChildMapper implements Mapper<ChildDTO,ChildEntity> {

	
	@Override
	public ChildDTO mapOfEntity(ChildEntity entity) {
		
		ChildDTO childDTO = ChildDTO.builder()
				.childName(entity.getChildName())
				.childSurname(entity.getChildSurname())
				.childYearBirth(entity.getChildYearBirth())
				.childCity(entity.getChildCity())
				.accountChildId(entity.getAccountChildId())
				.build();
		
		return childDTO;
	}
	
	@Override
	public ChildEntity mapOfDTO(ChildDTO dto) {
		
		ChildEntity childEntity = ChildEntity.builder()
				.childName(dto.getChildName())
				.childSurname(dto.getChildSurname())
				.childYearBirth(dto.getChildYearBirth())
				.childCity(dto.getChildCity())
				.accountChildId(dto.getAccountChildId())
				.build();
		
		return childEntity;
	}

	

}
