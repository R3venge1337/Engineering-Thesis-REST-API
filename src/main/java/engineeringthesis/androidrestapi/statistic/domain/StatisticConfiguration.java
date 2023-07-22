package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.statistic.StatisticResultFacade;
import engineeringthesis.androidrestapi.statistic.StatisticTypeFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class StatisticConfiguration {

    @Bean
    StatisticResultFacade statisticResultFacade(final StatisticResultRepository statisticResultRepository) {
        return new StatisticResultService(statisticResultRepository);
    }

    @Bean
    StatisticTypeFacade statisticTypeFacade(final StatisticTypeRepository statisticTypeRepository){
        return new StatisticTypeService(statisticTypeRepository);
    }
}
