package engineeringthesis.androidrestapi.category.dto;

import engineeringthesis.androidrestapi.teacher.dto.TeacherDto;

import java.util.UUID;

public record CategoryTeacherDto(UUID uuid, CategoryDto category, TeacherDto teacher) {

}
