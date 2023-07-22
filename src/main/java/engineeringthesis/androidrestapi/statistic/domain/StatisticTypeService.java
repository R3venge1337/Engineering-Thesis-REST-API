package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.statistic.StatisticTypeFacade;
import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticTypeForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticTypeDto;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticTypeForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class StatisticTypeService implements StatisticTypeFacade {


    private final StatisticTypeRepository statisticTypeRepository;

    @Override
    public List<StatisticTypeDto> getAllStatistic() {
        return statisticTypeRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public StatisticTypeDto saveStatisticType(final CreateStatisticTypeForm statisticTypeForm) {

        StatisticType statisticTypeEntity = new StatisticType();

        return mapToDto(statisticTypeRepository.save(statisticTypeEntity));
    }

    @Override
    public StatisticTypeDto findStatisticType(final UUID uuid) {
        return statisticTypeRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    @Transactional
    public void updateStatisticType(final UUID uuid, final UpdateStatisticTypeForm statisticTypeForm) {

        StatisticType statisticType = statisticTypeRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

        statisticType.setName(statisticTypeForm.name());
    }

    @Override
    public void deleteStatistic(final UUID uuid) {
        statisticTypeRepository.deleteByUuid(uuid);
    }

    private StatisticTypeDto mapToDto(final StatisticType statisticType) {
        return new StatisticTypeDto(statisticType.getName());
    }

}
