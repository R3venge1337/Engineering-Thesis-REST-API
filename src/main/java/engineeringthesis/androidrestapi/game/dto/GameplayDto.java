package engineeringthesis.androidrestapi.game.dto;

import engineeringthesis.androidrestapi.category.dto.CategoryDto;
import engineeringthesis.androidrestapi.child.dto.ChildDto;
import engineeringthesis.androidrestapi.language.dto.LanguageDto;

import java.time.LocalDateTime;

public record GameplayDto(LanguageDto language, GameDto game, CategoryDto categoryId, ChildDto child, String questUUID, LocalDateTime startDate, LocalDateTime endDate) {
}
