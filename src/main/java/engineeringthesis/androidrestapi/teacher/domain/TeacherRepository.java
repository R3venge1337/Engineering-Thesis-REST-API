package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface TeacherRepository extends UUIDAwareJpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {

    @Query("SELECT t FROM Teacher t INNER JOIN t.languageTeacher l WHERE l.name = :languageName ")
    List<Teacher> getTeachersByLanguageName(final String languageName);

    @Query("SELECT t FROM Teacher t INNER JOIN t.accountTeacher acc WHERE t.uuid = :uuid")
    Optional<Teacher> getTeacherWithAccount(final UUID uuid);
}
