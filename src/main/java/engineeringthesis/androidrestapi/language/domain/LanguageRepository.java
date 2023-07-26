package engineeringthesis.androidrestapi.language.domain;


import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


interface LanguageRepository extends UUIDAwareJpaRepository<Language, Long>, JpaSpecificationExecutor<Language> {
    Boolean existsByName(final String name);
}
