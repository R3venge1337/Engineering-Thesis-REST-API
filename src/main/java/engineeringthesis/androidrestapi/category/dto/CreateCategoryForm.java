package engineeringthesis.androidrestapi.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryForm(@NotBlank String name) {
}
