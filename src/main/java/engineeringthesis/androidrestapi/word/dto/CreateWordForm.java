package engineeringthesis.androidrestapi.word.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateWordForm(@NotBlank String name, @NotBlank String downloadUri) {
}
