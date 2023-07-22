package engineeringthesis.androidrestapi.game.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateGameForm(@NotBlank String name) {
}
