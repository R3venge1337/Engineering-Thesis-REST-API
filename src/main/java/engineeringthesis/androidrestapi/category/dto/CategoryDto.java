package engineeringthesis.androidrestapi.category.dto;

import engineeringthesis.androidrestapi.language.dto.LanguageDto;

import java.util.UUID;


public record CategoryDto(UUID uuid, String name, LanguageDto language) {
}
