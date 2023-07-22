package engineeringthesis.androidrestapi.statistic.controller;

import engineeringthesis.androidrestapi.statistic.StatisticResultFacade;
import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticResultForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDto;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticResultForm;
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
@RequestMapping(value = "/api/statistics/statisticResults")
@RequiredArgsConstructor
class StatisticResultController {


    private final StatisticResultFacade statisticResultServiceImpl;

    @GetMapping
    List<StatisticResultDto> getAllStatisticResults() {
        return statisticResultServiceImpl.getAllStatisticResults();
    }

    @GetMapping(value = "/{uuid}")
    StatisticResultDto findStatisticResult(@PathVariable final UUID uuid) {
        return statisticResultServiceImpl.findStatisticResult(uuid);
    }

    @PostMapping
    StatisticResultDto saveStatisticResults(@RequestBody final CreateStatisticResultForm statisticResultForm) {
        return statisticResultServiceImpl.saveStatisticResult(statisticResultForm);
    }

    @PutMapping(value = "/{uuid}")
    void updateStatisticResults(@PathVariable final UUID uuid, @RequestBody final UpdateStatisticResultForm statisticResultForm) {
        statisticResultServiceImpl.updateStatisticResult(uuid, statisticResultForm);
    }

    @DeleteMapping(value = "/{uuid}")
    void deleteStatisticResult(@PathVariable final UUID uuid) {
        statisticResultServiceImpl.deleteStatisticResults(uuid);
    }
}
