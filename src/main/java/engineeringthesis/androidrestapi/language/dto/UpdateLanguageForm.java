package engineeringthesis.androidrestapi.language.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateLanguageForm(@NotBlank String name) {
}
