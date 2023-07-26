package engineeringthesis.androidrestapi.role.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateRoleForm(@NotBlank String name) {
}
