package engineeringthesis.androidrestapi.image.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateImageForm(@NotBlank String downloadUri) {
}
