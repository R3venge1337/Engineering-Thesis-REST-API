package engineeringthesis.androidrestapi.language.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record LanguageDto(UUID uuid, String name, LocalDateTime createdDate) {
}
