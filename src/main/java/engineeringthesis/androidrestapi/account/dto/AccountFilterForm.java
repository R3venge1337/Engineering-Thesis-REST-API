package engineeringthesis.androidrestapi.account.dto;

import java.time.LocalDateTime;

public record AccountFilterForm(String name, String email, LocalDateTime createdDate, Boolean isActive, String role) {
}
