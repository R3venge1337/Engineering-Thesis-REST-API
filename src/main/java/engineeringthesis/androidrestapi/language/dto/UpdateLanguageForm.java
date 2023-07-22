package engineeringthesis.androidrestapi.language.dto;

import java.time.LocalDateTime;

public record UpdateLanguageForm(String name, LocalDateTime createdDate) {
}
