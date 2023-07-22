package engineeringthesis.androidrestapi.teacher;

import engineeringthesis.androidrestapi.teacher.dto.CreateTeacherForm;
import engineeringthesis.androidrestapi.teacher.dto.TeacherDto;
import engineeringthesis.androidrestapi.teacher.dto.UpdateTeacherForm;

import java.util.List;
import java.util.UUID;

public interface TeacherFacade {

	List<TeacherDto> getAllTeachers();

	TeacherDto findTeacher(final UUID uuid);
	
	TeacherDto saveTeacher(final CreateTeacherForm teacherForm);

	void updateTeacher(final UUID uuid, UpdateTeacherForm teacherForm);
	
	void deleteTeacher(final UUID uuid);
	
	List<TeacherDto> getTeachersByLanguageName(final String languageName);
	
	TeacherDto getTeacherWithAccount(final String accountName);
}
