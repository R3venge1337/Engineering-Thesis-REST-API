package engineeringthesis.androidrestapi.teacher.domain;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import engineeringthesis.androidrestapi.teacher.TeacherFacade;
import engineeringthesis.androidrestapi.teacher.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TeacherService implements TeacherFacade {

	
	private final TeacherRepository teacherRepository;
	private final TeacherMapper teacherMapper;

	@Override
	public List<TeacherDTO> getAllTeachers() {
		
		return teacherMapper.mapOfCollection(teacherRepository.findAll());
	}

	@Override
	public TeacherDTO saveTeacher(TeacherDTO teacherObj) {
		
		Teacher teacherEntity = teacherMapper.mapOfDTO(teacherObj);
		Teacher savedEntity =  teacherRepository.save(teacherEntity);
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
		
		Optional<Teacher> teacherEntity = teacherRepository.findById(teacherId);
		Teacher savedEntity = teacherEntity.get();
		savedEntity.setTeacherId(teacherObj.getTeacherId());
		savedEntity.setTeacherName(teacherObj.getTeacherName());
		savedEntity.setTeacherSurname(teacherObj.getTeacherSurname());
		savedEntity.setTeacherProfession(teacherObj.getTeacherProfession());
		savedEntity.setTeacherCity(teacherObj.getTeacherCity());
		savedEntity.setTeacherYearBirth(teacherObj.getTeacherYearBirth());
		teacherRepository.save(savedEntity);
		TeacherDTO dto = teacherMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteTeacher(Integer teacherId) {
		
		teacherRepository.deleteById(teacherId);
	}

	@Override
	public List<TeacherDTO> getTeachersByLanguageName(String languageName) {
	 return teacherMapper.mapOfCollection(teacherRepository.getTeachersByLanguageName(languageName));
	}

	@Override
	public TeacherDTO getTeacherWithAccount(String accountName) {
		
		return teacherMapper.mapOfEntity(teacherRepository.getTeacherWithAccount(accountName));
	}


	
}
