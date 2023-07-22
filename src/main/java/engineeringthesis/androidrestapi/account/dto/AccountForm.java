package engineeringthesis.androidrestapi.account.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AccountForm(@NotBlank String accountName, @NotBlank String accountPassword,
                          @NotNull LocalDateTime accountCreatedDate, @NotBlank @Email String accountEmail,
                          @NotNull Boolean active, @NotNull AccountRoleDto role) {
}
