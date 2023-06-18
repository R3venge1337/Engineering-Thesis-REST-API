package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.teacher.dto.TeacherDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class TeacherMapper implements Mapper<TeacherDTO, Teacher> {

	@Override
	public TeacherDTO mapOfEntity(Teacher entity) {
		
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
	public Teacher mapOfDTO(TeacherDTO dto) {
		
		Teacher teacherEntity = Teacher.builder()
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
