package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;

import java.util.Optional;

interface TeacherLanguageRepository extends UUIDAwareJpaRepository<TeacherLanguage, Long> {
    Optional<TeacherLanguage> findTeacherLanguageByName(final String name);
}
