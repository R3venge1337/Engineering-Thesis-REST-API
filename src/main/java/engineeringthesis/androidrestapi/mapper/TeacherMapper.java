package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.TeacherDTO;
import engineeringthesis.androidrestapi.entity.TeacherEntity;

@Component
public class TeacherMapper implements Mapper<TeacherDTO,TeacherEntity> {

	@Override
	public TeacherDTO mapOfEntity(TeacherEntity entity) {
		TeacherDTO teacherDTO = TeacherDTO.builder()
				.teacherName(entity.getTeacherName())
				.teacherSurname(entity.getTeacherSurname())
				.teacherProfession(entity.getTeacherProfession())
				.teacherCity(entity.getTeacherCity())
				.teacherAddress(entity.getTeacherAddress())
				.teacherYearBirth(entity.getTeacherYearBirth())
				.teacherZipCode(entity.getTeacherZipCode())
				.build();
		return teacherDTO;
	}

	@Override
	public TeacherEntity mapOfDTO(TeacherDTO dto) {
		
		TeacherEntity teacherEntity = TeacherEntity.builder()
				.teacherName(dto.getTeacherName())
				.teacherSurname(dto.getTeacherSurname())
				.teacherProfession(dto.getTeacherProfession())
				.teacherCity(dto.getTeacherCity())
				.teacherAddress(dto.getTeacherAddress())
				.teacherYearBirth(dto.getTeacherYearBirth())
				.teacherZipCode(dto.getTeacherZipCode())
				.build();
		return teacherEntity;
	}

}
