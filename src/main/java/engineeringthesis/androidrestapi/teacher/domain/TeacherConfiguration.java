package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.teacher.TeacherFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class TeacherConfiguration {

    @Bean
    TeacherFacade teacherFacade(final TeacherRepository teacherRepository, final TeacherAccountRepository accountRepository,
                                final TeacherLanguageRepository languageRepository, final TeacherRoleRepository roleRepository, final PasswordEncoder passwordEncoder) {
        return new TeacherService(teacherRepository, accountRepository, languageRepository, roleRepository, passwordEncoder);
    }
}
