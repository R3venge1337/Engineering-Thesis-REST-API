package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;

import java.util.Optional;

interface TeacherRoleRepository extends UUIDAwareJpaRepository<TeacherRole, Long> {
    Optional<TeacherRole> findTeacherRoleByName(final String name);
}
