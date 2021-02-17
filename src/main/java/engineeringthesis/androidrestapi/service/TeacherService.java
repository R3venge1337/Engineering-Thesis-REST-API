package engineeringthesis.androidrestapi.service;

import java.util.List;

import engineeringthesis.androidrestapi.dto.TeacherDTO;

public interface TeacherService {

	List<TeacherDTO> getAllTeachers();
	
	TeacherDTO saveTeacher(TeacherDTO teacherObj);
	
	TeacherDTO getOneByName(String name);
	
	TeacherDTO getOneById(Integer teacherId);
	
	TeacherDTO updateTeacher(Integer teacherId,TeacherDTO teacherObj);
	
	void deleteTeacher(Integer teacherId);
	
	List<TeacherDTO> getTeachersByLanguageName(String languageName);
	
	TeacherDTO getTeacherWithAccount(String accountName);
}
