package engineeringthesis.androidrestapi.game.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateGameplayResultForm(@NotBlank String statisticResults) {
}
