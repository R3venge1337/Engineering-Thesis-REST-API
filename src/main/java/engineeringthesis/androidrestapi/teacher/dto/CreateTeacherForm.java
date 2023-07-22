package engineeringthesis.androidrestapi.teacher.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTeacherForm(@NotBlank String name, @NotBlank String surname, @NotBlank String profession,
                                @NotBlank String city, @NotNull Short yearOfBirth) {
}
