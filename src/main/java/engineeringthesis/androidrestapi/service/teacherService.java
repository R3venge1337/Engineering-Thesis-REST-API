package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.teacher;

public interface teacherService {

	List<teacher> getAllTeachers();
	
	teacher saveTeacher(teacher teacherObj);
	
	teacher getOneByName(String name);
	
	Optional<teacher> getOneById(Integer teacherId);
	
	void deleteTeacher(Integer teacherId);
}
