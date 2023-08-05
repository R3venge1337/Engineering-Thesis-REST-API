package engineeringthesis.androidrestapi.teacher.dto;

import engineeringthesis.androidrestapi.account.dto.UpdateAccountForm;
import engineeringthesis.androidrestapi.language.dto.UpdateLanguageForm;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTeacherForm(@NotBlank String name, @NotBlank String surname, @NotBlank String profession,
                                @NotBlank String city, @NotNull Short yearOfBirth, @NotNull UpdateAccountForm account,
                                @NotNull UpdateLanguageForm language) {
}
