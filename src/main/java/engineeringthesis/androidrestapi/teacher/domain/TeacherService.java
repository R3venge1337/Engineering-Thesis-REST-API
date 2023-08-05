package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotUniqueException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import engineeringthesis.androidrestapi.teacher.TeacherFacade;
import engineeringthesis.androidrestapi.teacher.dto.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static engineeringthesis.androidrestapi.teacher.domain.TeacherService.ErrorMessages.*;

@RequiredArgsConstructor
class TeacherService implements TeacherFacade {

    private final TeacherRepository teacherRepository;

    private final TeacherAccountRepository accountRepository;

    private final TeacherLanguageRepository languageRepository;

    private final TeacherRoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    static final class ErrorMessages {
        static final String TEACHER_NOT_EXIST = "Teacher not exist";
        static final String TEACHER_ACCOUNT_NOT_EXIST = "Teacher with account not exist";
        static final String TEACHER_ROLE_NOT_EXIST = "Teacher role not exist";
        static final String TEACHER_LANGUAGE_NOT_EXIST = "Teacher language not exist";
        static final String TEACHER_ACCOUNT_EXIST = "Teacher with account has been found";

    }

    @Override
    public PageDto<TeacherDto> findTeachers(final TeacherFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final TeacherSpecification teacherSpecification = new TeacherSpecification(filterForm);

        final Page<TeacherDto> teachers = teacherRepository.findAll(teacherSpecification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(teachers);
    }

    @Override
    public TeacherDto findTeacher(final UUID uuid) {
        return teacherRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(TEACHER_NOT_EXIST));
    }

    @Override
    @Transactional
    public UuidDto saveTeacher(final CreateTeacherForm teacherForm) {
        DtoValidator.validate(teacherForm);
        checkUnique(teacherForm.account().name());


        final TeacherRole role = roleRepository.findTeacherRoleByName(teacherForm.account().role().name())
                .orElseThrow(() -> new NotFoundException(TEACHER_ROLE_NOT_EXIST));

        final TeacherLanguage language = languageRepository.findTeacherLanguageByName(teacherForm.language().name())
                .orElseThrow(() -> new NotFoundException(TEACHER_LANGUAGE_NOT_EXIST));

        final TeacherAccount teacherAccount = createTeacherAccount(teacherForm, role);

        final TeacherAccount savedAccount = accountRepository.save(teacherAccount);


        final Teacher teacher = createTeacher(teacherForm, language, savedAccount);

        return new UuidDto(teacherRepository.save(teacher).getUuid());
    }

    @Override
    @Transactional
    public void updateTeacher(final UUID uuid, final UpdateTeacherForm teacherForm) {
        DtoValidator.validate(teacherForm);

        final Teacher teacher = teacherRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(TEACHER_NOT_EXIST));

        final TeacherRole role = roleRepository.findTeacherRoleByName(teacherForm.account().role().name())
                .orElseThrow(() -> new NotFoundException(TEACHER_ROLE_NOT_EXIST));

        final TeacherLanguage language = languageRepository.findTeacherLanguageByName(teacherForm.language().name())
                .orElseThrow(() -> new NotFoundException(TEACHER_LANGUAGE_NOT_EXIST));

        final TeacherAccount accountTeacher = createTeacherAccount(teacherForm, teacher, role);

        createTeacher(teacherForm, teacher, language, accountTeacher);
    }

    @Override
    @Transactional
    public void deleteTeacher(final UUID uuid) {
        teacherRepository.deleteByUuid(uuid);
    }

    @Override
    public List<TeacherDto> findTeachersByLanguageName(final String languageName) {
        return teacherRepository.getTeachersByLanguageName(languageName).stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public TeacherWithAccountDto findTeacherWithAccount(final UUID uuid) {
        return teacherRepository.getTeacherWithAccount(uuid)
                .map(this::mapToTeacherAccountDto)
                .orElseThrow(() -> new NotFoundException(TEACHER_ACCOUNT_NOT_EXIST));
    }

    TeacherDto mapToDto(final Teacher teacher) {
        return new TeacherDto(teacher.getUuid(), teacher.getName(), teacher.getSurname(), teacher.getYearOfBirth(), teacher.getCity(), teacher.getProfession(), new TeacherLanguageDto(teacher.getLanguageTeacher().getName()));
    }

    TeacherWithAccountDto mapToTeacherAccountDto(final Teacher teacher) {
        return new TeacherWithAccountDto(teacher.getUuid(), teacher.getName(), teacher.getSurname(), teacher.getYearOfBirth(), teacher.getCity(), teacher.getProfession(), new TeacherLanguageDto(teacher.getLanguageTeacher().getName()), new TeacherAccountDto(teacher.getAccountTeacher().getNickname(), teacher.getAccountTeacher().getPassword(), teacher.getAccountTeacher().getEmail()));
    }

    private void createTeacher(final UpdateTeacherForm teacherForm, final Teacher teacher, final TeacherLanguage language, final TeacherAccount accountTeacher) {
        teacher.setName(teacherForm.name());
        teacher.setSurname(teacherForm.surname());
        teacher.setProfession(teacherForm.profession());
        teacher.setCity(teacherForm.city());
        teacher.setYearOfBirth(teacherForm.yearOfBirth());
        teacher.setAccountTeacher(accountTeacher);
        teacher.setLanguageTeacher(language);
    }

    private Teacher createTeacher(final CreateTeacherForm teacherForm, final TeacherLanguage language, final TeacherAccount savedAccount) {
        final Teacher teacher = new Teacher();
        teacher.setName(teacherForm.name());
        teacher.setSurname(teacherForm.surname());
        teacher.setCity(teacherForm.city());
        teacher.setYearOfBirth(teacherForm.yearOfBirth());
        teacher.setProfession(teacherForm.profession());
        teacher.setAccountTeacher(savedAccount);
        teacher.setLanguageTeacher(language);
        return teacher;
    }

    private TeacherAccount createTeacherAccount(final UpdateTeacherForm teacherForm, final Teacher teacher, final TeacherRole role) {
        final TeacherAccount accountTeacher = teacher.getAccountTeacher();
        accountTeacher.setNickname(teacherForm.account().name());
        accountTeacher.setEmail(teacherForm.account().email());
        accountTeacher.setPassword(passwordEncoder.encode(teacherForm.account().password()));
        accountTeacher.setIsActive(teacherForm.account().active());
        accountTeacher.setRole(role);
        return accountTeacher;
    }

    private TeacherAccount createTeacherAccount(final CreateTeacherForm teacherForm, final TeacherRole role) {
        final TeacherAccount teacherAccount = new TeacherAccount();
        teacherAccount.setNickname(teacherForm.account().name());
        teacherAccount.setPassword(passwordEncoder.encode(teacherForm.account().password()));
        teacherAccount.setEmail(teacherForm.account().email());
        teacherAccount.setIsActive(teacherForm.account().active());
        teacherAccount.setRole(role);
        teacherAccount.setCreatedDate(LocalDateTime.now());
        return teacherAccount;
    }

    private void checkUnique(final String formLogin, final String entityLogin) {
        if (!formLogin.equals(entityLogin)) {
            checkUnique(formLogin);
        }
    }

    void checkUnique(final String login) {
        if (accountRepository.existsByName(login)) {
            throw new NotUniqueException(TeacherAccount.Fields.nickname, TEACHER_ACCOUNT_EXIST);
        }
    }
}
