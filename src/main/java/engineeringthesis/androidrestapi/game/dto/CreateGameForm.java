package engineeringthesis.androidrestapi.game.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateGameForm(@NotBlank String name) {
}
