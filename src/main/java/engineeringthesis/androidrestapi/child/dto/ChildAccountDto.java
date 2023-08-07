package engineeringthesis.androidrestapi.child.dto;

import java.util.UUID;

public record ChildAccountDto(UUID uuid, String name, String password, String email, Boolean isActive, String role) {
}
