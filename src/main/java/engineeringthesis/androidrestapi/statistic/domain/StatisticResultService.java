package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import engineeringthesis.androidrestapi.statistic.StatisticResultFacade;
import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticResultForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDto;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultFilterForm;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticResultForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.UUID;

import static engineeringthesis.androidrestapi.statistic.domain.StatisticResultService.ErrorMessages.STATISTIC_RESULT_NOT_EXIST;

@RequiredArgsConstructor
class StatisticResultService implements StatisticResultFacade {


    private final StatisticResultRepository statisticResultRepository;

    static final class ErrorMessages {
        static final String STATISTIC_RESULT_NOT_EXIST = "Statistic result not exist";
        static final String STATISTIC_RESULT_FOUND = "Statistic result was found";
    }

    @Override
    public PageDto<StatisticResultDto> findStatisticResults(final StatisticResultFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final StatisticResultSpecification specification = new StatisticResultSpecification(filterForm);
        final Page<StatisticResultDto> results = statisticResultRepository.findAll(specification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(results);
    }

    @Override
    @Transactional
    public UuidDto saveStatisticResult(final CreateStatisticResultForm createForm) {
        DtoValidator.validate(createForm);

        final StatisticResult statisticResultEntity = new StatisticResult();
        statisticResultEntity.setResult(createForm.result());

        return new UuidDto(statisticResultRepository.save(statisticResultEntity).getUuid());
    }

    @Override
    public StatisticResultDto findStatisticResult(final UUID uuid) {
        return statisticResultRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(STATISTIC_RESULT_NOT_EXIST));
    }

    @Override
    @Transactional
    public void updateStatisticResult(final UUID uuid, final UpdateStatisticResultForm updateForm) {
        DtoValidator.validate(updateForm);

        final StatisticResult statisticResult = statisticResultRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(STATISTIC_RESULT_NOT_EXIST));

        statisticResult.setResult(updateForm.result());
    }

    @Override
    @Transactional
    public void deleteStatisticResults(final UUID uuid) {
        statisticResultRepository.deleteByUuid(uuid);
    }

    StatisticResultDto mapToDto(final StatisticResult statisticResult) {
        return new StatisticResultDto(statisticResult.getResult(), null);
    }
}
