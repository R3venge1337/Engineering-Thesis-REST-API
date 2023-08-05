package engineeringthesis.androidrestapi.child.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateChildForm(@NotBlank String name, @NotBlank String surname, @NotNull Short childYearBirth, @NotBlank String city, @NotNull ChildAccountDto account) {
}
