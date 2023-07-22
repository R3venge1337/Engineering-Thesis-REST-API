package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.statistic.StatisticResultFacade;
import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticResultForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDto;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticResultForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class StatisticResultService implements StatisticResultFacade {


    private final StatisticResultRepository statisticResultRepository;

    @Override
    public List<StatisticResultDto> getAllStatisticResults() {
        return statisticResultRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public StatisticResultDto saveStatisticResult(final CreateStatisticResultForm resultForm) {

        StatisticResult statisticResultEntity = new StatisticResult();

        return mapToDto(statisticResultRepository.save(statisticResultEntity));
    }

    @Override
    public StatisticResultDto findStatisticResult(final UUID uuid) {
        return statisticResultRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    @Transactional
    public void updateStatisticResult(final UUID uuid, final UpdateStatisticResultForm resultForm) {

        StatisticResult statisticResult = statisticResultRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

        statisticResult.setResult(resultForm.statisticResults());
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
