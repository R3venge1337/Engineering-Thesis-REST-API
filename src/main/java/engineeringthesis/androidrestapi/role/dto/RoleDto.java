package engineeringthesis.androidrestapi.role.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record RoleDto(UUID uuid, String name, LocalDateTime roleCreatedDate) {
}
