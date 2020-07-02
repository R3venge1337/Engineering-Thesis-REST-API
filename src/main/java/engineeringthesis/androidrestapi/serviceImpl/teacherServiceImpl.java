package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.teacher;
import engineeringthesis.androidrestapi.repository.teacherRepository;
import engineeringthesis.androidrestapi.service.teacherService;

@Service
@Transactional
public class teacherServiceImpl implements teacherService{

	@Autowired
	teacherRepository teacherRepo;

	@Override
	public List<teacher> getAllTeachers() {
		return teacherRepo.findAll();
	}

	@Override
	public teacher saveTeacher(teacher teacherObj) {
		return teacherRepo.save(teacherObj);
	}

	@Override
	public teacher getOneByName(String name) {
		return null;
	}

	@Override
	public Optional<teacher> getOneById(Integer teacherId) {
		return teacherRepo.findById(teacherId);
	}

	@Override
	public void deleteTeacher(Integer teacherId) {
		teacherRepo.deleteById(teacherId);
		
	}
	
	
}
