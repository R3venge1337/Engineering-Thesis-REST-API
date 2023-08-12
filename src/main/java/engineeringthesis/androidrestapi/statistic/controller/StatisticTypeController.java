package engineeringthesis.androidrestapi.statistic.controller;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.statistic.StatisticTypeFacade;
import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticTypeForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticFilterForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticTypeDto;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticTypeForm;
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

import static engineeringthesis.androidrestapi.statistic.controller.StatisticTypeController.Routes.ROOT;
import static engineeringthesis.androidrestapi.statistic.controller.StatisticTypeController.Routes.ROOT_UUID;

@RestController
@RequiredArgsConstructor
class StatisticTypeController {

    private final StatisticTypeFacade statisticServiceImpl;

    static final class Routes {
        static final String ROOT = "/statistics";
        static final String ROOT_UUID = ROOT + "/{uuid}";
    }

    @GetMapping(ROOT)
    PageDto<StatisticTypeDto> findStatisticsTypes(@RequestBody final StatisticFilterForm filterForm, final PageableRequest pageableRequest) {
        return statisticServiceImpl.findStatistics(filterForm, pageableRequest);
    }

    @GetMapping(ROOT_UUID)
    StatisticTypeDto getStatisticType(@PathVariable final UUID uuid) {
        return statisticServiceImpl.findStatisticType(uuid);
    }

    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    UuidDto saveStatistic(@RequestBody final CreateStatisticTypeForm createForm) {
        return statisticServiceImpl.saveStatisticType(createForm);
    }

    @PutMapping(ROOT_UUID)
    void updateStatistic(@PathVariable final UUID uuid, @RequestBody final UpdateStatisticTypeForm updateForm) {
        statisticServiceImpl.updateStatisticType(uuid, updateForm);
    }

    @DeleteMapping(ROOT_UUID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteStatistic(@PathVariable final UUID uuid) {
        statisticServiceImpl.deleteStatistic(uuid);
    }

}
