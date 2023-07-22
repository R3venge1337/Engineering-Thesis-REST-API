package engineeringthesis.androidrestapi.statistic.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateStatisticResultForm(@NotBlank String result) {
}
