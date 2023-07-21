package engineeringthesis.androidrestapi.audio.domain;

import engineeringthesis.androidrestapi.audio.AudioFacade;
import engineeringthesis.androidrestapi.common.entity.ReaderPropertiesFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AudioConfiguration {
    @Bean
    AudioFacade audioFacade(final AudioRepository audioRepository,
                            final ReaderPropertiesFile readerPropertiesFile,
                            final AudioFileTableRepository audioFileTableRepository) {
        return new AudioService(audioRepository, readerPropertiesFile, audioFileTableRepository);
    }
}
