package engineeringthesis.androidrestapi.statistic.controller;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.statistic.StatisticResultFacade;
import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticResultForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDto;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultFilterForm;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticResultForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static engineeringthesis.androidrestapi.statistic.controller.StatisticResultController.Routes.ROOT;
import static engineeringthesis.androidrestapi.statistic.controller.StatisticResultController.Routes.ROOT_UUID;

@RestController
@RequiredArgsConstructor
class StatisticResultController {

    private final StatisticResultFacade statisticResultServiceImpl;


    static final class Routes {
        static final String ROOT = "/statistics/statisticResults";

        static final String ROOT_UUID = ROOT + "/{uuid}";
    }

    @GetMapping(ROOT)
    PageDto<StatisticResultDto> findStatisticResults(@RequestBody final StatisticResultFilterForm filterForm, final PageableRequest pageableRequest) {
        return statisticResultServiceImpl.findStatisticResults(filterForm, pageableRequest);
    }

    @GetMapping(ROOT_UUID)
    StatisticResultDto findStatisticResult(@PathVariable final UUID uuid) {
        return statisticResultServiceImpl.findStatisticResult(uuid);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveStatisticResults(@RequestBody final CreateStatisticResultForm statisticResultForm) {
        return statisticResultServiceImpl.saveStatisticResult(statisticResultForm);
    }

    @PutMapping(ROOT_UUID)
    void updateStatisticResults(@PathVariable final UUID uuid, @RequestBody final UpdateStatisticResultForm statisticResultForm) {
        statisticResultServiceImpl.updateStatisticResult(uuid, statisticResultForm);
    }

    @DeleteMapping(ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteStatisticResult(@PathVariable final UUID uuid) {
        statisticResultServiceImpl.deleteStatisticResults(uuid);
    }
}
