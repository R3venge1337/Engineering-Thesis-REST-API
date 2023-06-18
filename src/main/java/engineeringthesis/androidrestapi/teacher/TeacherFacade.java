package engineeringthesis.androidrestapi.teacher;

import engineeringthesis.androidrestapi.teacher.dto.TeacherDTO;

import java.util.List;

public interface TeacherFacade {

	List<TeacherDTO> getAllTeachers();
	
	TeacherDTO saveTeacher(TeacherDTO teacherObj);
	
	TeacherDTO getOneByName(String name);
	
	TeacherDTO getOneById(Integer teacherId);
	
	TeacherDTO updateTeacher(Integer teacherId,TeacherDTO teacherObj);
	
	void deleteTeacher(Integer teacherId);
	
	List<TeacherDTO> getTeachersByLanguageName(String languageName);
	
	TeacherDTO getTeacherWithAccount(String accountName);
}
