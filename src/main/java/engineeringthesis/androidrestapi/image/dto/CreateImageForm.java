package engineeringthesis.androidrestapi.image.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateImageForm(@NotBlank String downloadUri) {
}
