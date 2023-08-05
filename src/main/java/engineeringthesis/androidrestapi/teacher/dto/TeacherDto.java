package engineeringthesis.androidrestapi.teacher.dto;


import java.util.UUID;

public record TeacherDto(UUID uuid, String name, String surname, Short yearOfBirth, String city, String profession,
                         TeacherLanguageDto language) {
}
