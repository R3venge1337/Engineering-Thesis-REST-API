package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.dto.TeacherDTO;
import engineeringthesis.androidrestapi.entity.TeacherEntity;
import engineeringthesis.androidrestapi.mapper.TeacherMapper;
import engineeringthesis.androidrestapi.repository.TeacherRepository;
import engineeringthesis.androidrestapi.service.TeacherService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

	
	private final TeacherRepository teacherRepository;
	private final TeacherMapper teacherMapper;

	@Override
	public List<TeacherDTO> getAllTeachers() {
		
		return teacherMapper.mapOfCollection(teacherRepository.findAll());
	}

	@Override
	public TeacherDTO saveTeacher(TeacherDTO teacherObj) {
		
		TeacherEntity teacherEntity = teacherMapper.mapOfDTO(teacherObj);
		TeacherEntity savedEntity =  teacherRepository.save(teacherEntity);
		return teacherMapper.mapOfEntity(savedEntity);
	}

	@Override
	public TeacherDTO getOneByName(String name) {
		
		return null;
	}

	@Override
	public TeacherDTO getOneById(Integer teacherId) {
		
		return teacherMapper.mapOfEntity(teacherRepository.findById(teacherId).get());
	}
	
	@Override
	public TeacherDTO updateTeacher(Integer teacherId, TeacherDTO teacherObj) {
		
		Optional<TeacherEntity> teacherEntity = teacherRepository.findById(teacherId);
		TeacherEntity savedEntity = teacherEntity.get();
		savedEntity.setTeacherName(teacherObj.getTeacherName());
		savedEntity.setTeacherSurname(teacherObj.getTeacherSurname());
		savedEntity.setTeacherProfession(teacherObj.getTeacherProfession());
		savedEntity.setTeacherCity(teacherObj.getTeacherCity());
		savedEntity.setTeacherZipCode(teacherObj.getTeacherZipCode());
		savedEntity.setTeacherAddress(teacherObj.getTeacherAddress());
		savedEntity.setTeacherYearBirth(teacherObj.getTeacherYearBirth());
		teacherRepository.save(savedEntity);
		TeacherDTO dto = teacherMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteTeacher(Integer teacherId) {
		
		teacherRepository.deleteById(teacherId);
	}


	
}
