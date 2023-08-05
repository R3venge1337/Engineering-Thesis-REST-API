package engineeringthesis.androidrestapi.teacher.controller;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.teacher.TeacherFacade;
import engineeringthesis.androidrestapi.teacher.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static engineeringthesis.androidrestapi.teacher.controller.TeacherController.Routes.ROOT;
import static engineeringthesis.androidrestapi.teacher.controller.TeacherController.Routes.ROOT_ACCOUNTS;
import static engineeringthesis.androidrestapi.teacher.controller.TeacherController.Routes.ROOT_UUID;

@RestController
@RequiredArgsConstructor
class TeacherController {

    private final TeacherFacade teacherServiceImpl;

    static final class Routes {
        static final String ROOT = "/teachers";
        static final String ROOT_UUID = ROOT + "/{uuid}";

        static final String ROOT_ACCOUNTS = ROOT_UUID + "/accounts";
    }

    @GetMapping(ROOT)
    PageDto<TeacherDto> findTeachers(final TeacherFilterForm filterForm, final PageableRequest pageableRequest) {
        return teacherServiceImpl.findTeachers(filterForm, pageableRequest);
    }

    @GetMapping(ROOT_UUID)
    TeacherDto findTeacher(@PathVariable final UUID uuid) {
        return teacherServiceImpl.findTeacher(uuid);

    }

    @GetMapping(value = ROOT, params = "nickname")
    List<TeacherDto> findTeachersByLanguageName(@RequestParam(required = false) final String name) {
        return teacherServiceImpl.findTeachersByLanguageName(name);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveTeacher(@RequestBody final CreateTeacherForm teacherForm) {
        return teacherServiceImpl.saveTeacher(teacherForm);
    }

    @PutMapping(ROOT_UUID)
    void updateTeacher(@PathVariable final UUID uuid, @RequestBody final UpdateTeacherForm teacherForm) {
        teacherServiceImpl.updateTeacher(uuid, teacherForm);
    }

    @DeleteMapping(ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTeacher(@PathVariable final UUID uuid) {
        teacherServiceImpl.deleteTeacher(uuid);
    }

    @GetMapping(value = ROOT_ACCOUNTS)
    TeacherWithAccountDto findTeacherWithAccount(@PathVariable final UUID uuid) {
        return teacherServiceImpl.findTeacherWithAccount(uuid);
    }
}
