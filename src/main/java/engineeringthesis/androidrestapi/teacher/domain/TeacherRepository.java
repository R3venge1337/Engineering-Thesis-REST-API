package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface TeacherRepository extends UUIDAwareJpaRepository<Teacher, Integer> {

    @Query("SELECT t FROM Teacher t INNER JOIN t.languageTeacher l WHERE l.name = :languageName ")
    List<Teacher> getTeachersByLanguageName(final String languageName);

    @Query("SELECT t FROM Teacher t INNER JOIN t.accountTeacher acc WHERE acc.name = :accountName ")
    Teacher getTeacherWithAccount(final String accountName);
}
