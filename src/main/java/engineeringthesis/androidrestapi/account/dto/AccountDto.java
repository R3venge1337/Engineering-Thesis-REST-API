package engineeringthesis.androidrestapi.account.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record AccountDto(UUID uuid, String name, String password, String email, Boolean isActive,
                         LocalDateTime createdDate, String role) {
}
