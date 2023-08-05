package engineeringthesis.androidrestapi.teacher;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.teacher.dto.*;

import java.util.List;
import java.util.UUID;

public interface TeacherFacade {

	PageDto<TeacherDto> findTeachers(final TeacherFilterForm filterForm, final PageableRequest pageableRequest);

	TeacherDto findTeacher(final UUID uuid);
	
	UuidDto saveTeacher(final CreateTeacherForm teacherForm);

	void updateTeacher(final UUID uuid, UpdateTeacherForm teacherForm);
	
	void deleteTeacher(final UUID uuid);
	
	List<TeacherDto> findTeachersByLanguageName(final String languageName);
	
	TeacherWithAccountDto findTeacherWithAccount(final UUID uuid);
}
