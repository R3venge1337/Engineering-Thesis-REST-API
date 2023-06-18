package engineeringthesis.androidrestapi.language.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface LanguageRepository extends JpaRepository<Language, Integer>{

	@Query("SELECT l FROM LanguageEntity l WHERE l.languageName = :name ")
	Language findByLanguageName(@Param("name") String name);
}
