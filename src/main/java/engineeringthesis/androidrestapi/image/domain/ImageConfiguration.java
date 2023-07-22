package engineeringthesis.androidrestapi.image.domain;

import engineeringthesis.androidrestapi.common.entity.ReaderPropertiesFile;
import engineeringthesis.androidrestapi.image.ImageFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ImageConfiguration {

    @Bean
    ImageFacade imageFacade(final ImageRepository imageRepository,
                            final ReaderPropertiesFile readerPropertiesFile,
                            final ImageFileTableRepository fileTableRepository
    ){
        return new ImageService(imageRepository,readerPropertiesFile,fileTableRepository);
    }
}
