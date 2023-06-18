package engineeringthesis.androidrestapi.language;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer>{

	@Query("SELECT l FROM LanguageEntity l WHERE l.languageName = :name ")
	LanguageEntity findByLanguageName(@Param("name") String name);
}
