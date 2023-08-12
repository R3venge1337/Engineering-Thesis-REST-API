package engineeringthesis.androidrestapi.statistic;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticResultForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDto;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultFilterForm;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticResultForm;

import java.util.UUID;

public interface StatisticResultFacade {

    PageDto<StatisticResultDto> findStatisticResults(final StatisticResultFilterForm filterForm, final PageableRequest pageableRequest);

    UuidDto saveStatisticResult(final CreateStatisticResultForm createForm);

    StatisticResultDto findStatisticResult(final UUID uuid);

    void updateStatisticResult(final UUID uuid, final UpdateStatisticResultForm updateForm);

    void deleteStatisticResults(final UUID uuid);
}
