package engineeringthesis.androidrestapi.category.domain;

import engineeringthesis.androidrestapi.category.CategoryFacade;
import engineeringthesis.androidrestapi.category.CategoryTeacherFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CategoryConfiguration {

    @Bean
    CategoryFacade categoryFacade(final CategoryRepository categoryRepository){
        return new CategoryService(categoryRepository);
    }

    @Bean
    CategoryTeacherFacade categoryTeacherFacade(final CategoryTeacherRepository categoryTeacherRepository) {
        return new CategoryTeacherService(categoryTeacherRepository);
    }
}
