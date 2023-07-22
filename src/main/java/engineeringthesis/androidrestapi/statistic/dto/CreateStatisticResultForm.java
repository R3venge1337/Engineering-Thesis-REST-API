package engineeringthesis.androidrestapi.statistic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateStatisticResultForm(@NotBlank String result, @NotNull StatisticTypeDto type) {
}
