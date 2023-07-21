package engineeringthesis.androidrestapi.category.dto;

import engineeringthesis.androidrestapi.language.dto.LanguageDTO;

import java.util.UUID;


public record CategoryDto(UUID uuid, String name, LanguageDTO language) {
}
