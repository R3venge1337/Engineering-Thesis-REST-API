package engineeringthesis.androidrestapi.role.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateRoleForm(@NotBlank String name) {
}
