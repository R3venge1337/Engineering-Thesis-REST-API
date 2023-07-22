package engineeringthesis.androidrestapi.game.dto;

import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDto;

import java.util.UUID;


public record GameplayResultDto(UUID uuid, GameplayDto gameplay, StatisticResultDto statisticResults) {
}
