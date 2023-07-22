package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.teacher.TeacherFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TeacherConfiguration {

    @Bean
    TeacherFacade teacherFacade(final TeacherRepository teacherRepository){
        return new TeacherService(teacherRepository);
    }
}
