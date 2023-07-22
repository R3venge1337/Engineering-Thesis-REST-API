package engineeringthesis.androidrestapi.statistic.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateStatisticTypeForm(@NotBlank String name) {
}
