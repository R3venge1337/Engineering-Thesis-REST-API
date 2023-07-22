package engineeringthesis.androidrestapi.category.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateCategoryForm(@NotBlank String name) {
}
