package engineeringthesis.androidrestapi.language.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateLanguageForm(@NotBlank String name) {
}
