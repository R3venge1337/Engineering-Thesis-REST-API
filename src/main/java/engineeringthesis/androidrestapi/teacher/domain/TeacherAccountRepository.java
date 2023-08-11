package engineeringthesis.androidrestapi.teacher.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;

interface TeacherAccountRepository extends UUIDAwareJpaRepository<TeacherAccount, Long> {
    Boolean existsByNickname(final String name);

}
