package engineeringthesis.androidrestapi.statistic.controller;

import engineeringthesis.androidrestapi.statistic.StatisticTypeFacade;
import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticTypeForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticTypeDto;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticTypeForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/statistics")
@RequiredArgsConstructor
class StatisticTypeController {

    private final StatisticTypeFacade statisticServiceImpl;

    @GetMapping
    List<StatisticTypeDto> getAllStatisticsTypes() {
        return statisticServiceImpl.getAllStatistic();
    }

    @GetMapping(value = "/{uuid}")
    StatisticTypeDto getStatisticType(@PathVariable final UUID uuid) {
        return statisticServiceImpl.findStatisticType(uuid);
    }

    @PostMapping
    StatisticTypeDto saveStatistic(@RequestBody final CreateStatisticTypeForm createStatisticTypeForm) {
        return statisticServiceImpl.saveStatisticType(createStatisticTypeForm);
    }

    @PutMapping(value = "/{uuid}")
    void updateStatistic(@PathVariable final UUID uuid, @RequestBody final UpdateStatisticTypeForm statisticTypeForm) {
        statisticServiceImpl.updateStatisticType(uuid, statisticTypeForm);
    }

    @DeleteMapping(value = "/{uuid}")
    void deleteStatistic(@PathVariable final UUID uuid) {
        statisticServiceImpl.deleteStatistic(uuid);
    }

}
