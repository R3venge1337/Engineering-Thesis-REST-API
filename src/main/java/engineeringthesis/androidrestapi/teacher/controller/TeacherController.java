package engineeringthesis.androidrestapi.teacher.controller;

import engineeringthesis.androidrestapi.teacher.TeacherFacade;
import engineeringthesis.androidrestapi.teacher.dto.CreateTeacherForm;
import engineeringthesis.androidrestapi.teacher.dto.TeacherDto;
import engineeringthesis.androidrestapi.teacher.dto.UpdateTeacherForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/teachers")
@RequiredArgsConstructor
class TeacherController {

    private final TeacherFacade teacherServiceImpl;

    @GetMapping
    List<TeacherDto> getAllTeachers() {
        return teacherServiceImpl.getAllTeachers();
    }

    @GetMapping(value = "/{uuid}")
    TeacherDto getTeacher(@PathVariable final UUID uuid) {
        return teacherServiceImpl.findTeacher(uuid);

    }

    @GetMapping(params = "name")
    List<TeacherDto> getTeacherByLanguageName(@RequestParam(required = false) final String name) {
        return teacherServiceImpl.getTeachersByLanguageName(name);
    }

    @PostMapping
    TeacherDto saveTeacher(@RequestBody final CreateTeacherForm teacherForm) {
        return teacherServiceImpl.saveTeacher(teacherForm);
    }

    @PutMapping(value = "/{uuid}")
    void updateTeacher(@PathVariable final UUID uuid, @RequestBody final UpdateTeacherForm teacherForm) {
        teacherServiceImpl.updateTeacher(uuid, teacherForm);
    }

    @DeleteMapping(value = "/{uuid}")
    void deleteTeacherById(@PathVariable final UUID uuid) {
        teacherServiceImpl.deleteTeacher(uuid);
    }

    @GetMapping(value = "/accounts")
    TeacherDto getTeacherWithAccount(@RequestParam final String accountName) {
        return teacherServiceImpl.getTeacherWithAccount(accountName);
    }
}
