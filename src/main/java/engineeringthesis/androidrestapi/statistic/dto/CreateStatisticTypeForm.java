package engineeringthesis.androidrestapi.statistic.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateStatisticTypeForm(@NotBlank String name) {
}
