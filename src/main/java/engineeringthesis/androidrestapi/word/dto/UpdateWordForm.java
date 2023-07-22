package engineeringthesis.androidrestapi.word.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateWordForm(@NotBlank String name, @NotBlank String downloadUri) {
}
