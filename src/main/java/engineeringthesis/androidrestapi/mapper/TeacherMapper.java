package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.TeacherDTO;
import engineeringthesis.androidrestapi.entity.TeacherEntity;

@Component
public class TeacherMapper implements Mapper<TeacherDTO,TeacherEntity> {

	@Override
	public TeacherDTO mapOfEntity(TeacherEntity entity) {
		
		TeacherDTO teacherDTO = TeacherDTO.builder()
				.teacherId(entity.getTeacherId())
				.teacherName(entity.getTeacherName())
				.teacherSurname(entity.getTeacherSurname())
				.teacherProfession(entity.getTeacherProfession())
				.teacherCity(entity.getTeacherCity())
				.teacherYearBirth(entity.getTeacherYearBirth())
				.accountTeacherId(entity.getAccountTeacherId())
				.languageTeacherId(entity.getLanguageTeacherId())
				.build();
		return teacherDTO;
	}

	@Override
	public TeacherEntity mapOfDTO(TeacherDTO dto) {
		
		TeacherEntity teacherEntity = TeacherEntity.builder()
				.teacherId(dto.getTeacherId())
				.teacherName(dto.getTeacherName())
				.teacherSurname(dto.getTeacherSurname())
				.teacherProfession(dto.getTeacherProfession())
				.teacherCity(dto.getTeacherCity())
				.teacherYearBirth(dto.getTeacherYearBirth())
				.accountTeacherId(dto.getAccountTeacherId())
				.languageTeacherId(dto.getLanguageTeacherId())
				.build();
		return teacherEntity;
	}

}
