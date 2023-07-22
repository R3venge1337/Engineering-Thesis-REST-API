package engineeringthesis.androidrestapi.language.domain;


import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.Query;


interface LanguageRepository extends UUIDAwareJpaRepository<Language, Integer> {

    @Query("SELECT l FROM Language l WHERE l.name = :name ")
    Language findByLanguageName(final String name);
}
