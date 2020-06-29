package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.model.language;

@Repository
public interface languageRepository extends JpaRepository<language, Integer>{

	@Query("SELECT l FROM language l WHERE l.languageName = :name ")
	 language findByLanguageName(@Param("name") String name);
}
