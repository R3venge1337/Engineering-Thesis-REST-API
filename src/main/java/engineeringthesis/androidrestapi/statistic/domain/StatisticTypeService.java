package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import engineeringthesis.androidrestapi.statistic.StatisticTypeFacade;
import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticTypeForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticFilterForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticTypeDto;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticTypeForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.UUID;

import static engineeringthesis.androidrestapi.statistic.domain.StatisticTypeService.ErrorMessages.STATISTIC_NOT_EXIST;

@RequiredArgsConstructor
class StatisticTypeService implements StatisticTypeFacade {


    private final StatisticTypeRepository statisticTypeRepository;

    static final class ErrorMessages {
        static final String STATISTIC_NOT_EXIST = "Statistic  not exist";
    }

    @Override
    public PageDto<StatisticTypeDto> findStatistics(final StatisticFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final StatisticSpecification specification = new StatisticSpecification(filterForm);
        final Page<StatisticTypeDto> statistics = statisticTypeRepository.findAll(specification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(statistics);
    }

    @Override
    @Transactional
    public UuidDto saveStatisticType(final CreateStatisticTypeForm createForm) {
        DtoValidator.validate(createForm);

        StatisticType statistic = new StatisticType();
        statistic.setName(createForm.name());

        return new UuidDto(statisticTypeRepository.save(statistic).getUuid());
    }

    @Override
    public StatisticTypeDto findStatisticType(final UUID uuid) {
        return statisticTypeRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(STATISTIC_NOT_EXIST));
    }

    @Override
    @Transactional
    public void updateStatisticType(final UUID uuid, final UpdateStatisticTypeForm updateForm) {
        DtoValidator.validate(updateForm);

        final StatisticType statisticType = statisticTypeRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(STATISTIC_NOT_EXIST));

        statisticType.setName(updateForm.name());
    }

    @Override
    public void deleteStatistic(final UUID uuid) {
        statisticTypeRepository.deleteByUuid(uuid);
    }

    private StatisticTypeDto mapToDto(final StatisticType statisticType) {
        return new StatisticTypeDto(statisticType.getName());
    }

}
