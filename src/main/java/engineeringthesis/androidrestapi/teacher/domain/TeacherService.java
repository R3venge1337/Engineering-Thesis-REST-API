package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.teacher.TeacherFacade;
import engineeringthesis.androidrestapi.teacher.dto.CreateTeacherForm;
import engineeringthesis.androidrestapi.teacher.dto.TeacherAccountDto;
import engineeringthesis.androidrestapi.teacher.dto.TeacherDto;
import engineeringthesis.androidrestapi.teacher.dto.TeacherLanguageDto;
import engineeringthesis.androidrestapi.teacher.dto.UpdateTeacherForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class TeacherService implements TeacherFacade {

    private final TeacherRepository teacherRepository;

    @Override
    public List<TeacherDto> getAllTeachers() {

        return teacherRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public TeacherDto findTeacher(final UUID uuid) {
        return teacherRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    public TeacherDto saveTeacher(final CreateTeacherForm teacherForm) {

        final Teacher teacher = new Teacher();
        teacher.setName(teacherForm.name());
        teacher.setSurname(teacherForm.surname());
        teacher.setCity(teacherForm.city());
        teacher.setYearOfBirth(teacherForm.yearOfBirth());
        teacher.setProfession(teacherForm.profession());

        final Teacher savedEntity = teacherRepository.save(teacher);
        return mapToDto(savedEntity);
    }

    @Override
    @Transactional
    public void updateTeacher(final UUID uuid, final UpdateTeacherForm teacherForm) {
        final Teacher teacher = teacherRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

        teacher.setName(teacherForm.name());
        teacher.setSurname(teacherForm.surname());
        teacher.setProfession(teacherForm.profession());
        teacher.setCity(teacherForm.city());
        teacher.setYearOfBirth(teacherForm.yearOfBirth());
    }

    @Override
    @Transactional
    public void deleteTeacher(final UUID uuid) {
        teacherRepository.deleteByUuid(uuid);
    }

    @Override
    public List<TeacherDto> getTeachersByLanguageName(final String languageName) {
        return teacherRepository.getTeachersByLanguageName(languageName).stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public TeacherDto getTeacherWithAccount(final String accountName) {
        return mapToDto(teacherRepository.getTeacherWithAccount(accountName));
    }

    TeacherDto mapToDto(final Teacher teacher) {
        return new TeacherDto(teacher.getUuid(), teacher.getName(), teacher.getSurname(), teacher.getYearOfBirth(), teacher.getCity(), teacher.getProfession(), new TeacherLanguageDto(teacher.getName()), new TeacherAccountDto(teacher.getAccountTeacher().getName(), teacher.getAccountTeacher().getPassword(), teacher.getAccountTeacher().getEmail()));
    }
}
