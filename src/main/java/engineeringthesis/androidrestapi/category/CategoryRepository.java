package engineeringthesis.androidrestapi.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
	
	@Query("SELECT c FROM CategoryEntity c INNER JOIN LanguageEntity l ON c.languageId = l.languageId WHERE l.languageName = :languageName ")
	List<CategoryEntity> getCategoriesByLanguage(@Param("languageName") String languageName);
	
	@Query("SELECT c FROM CategoryEntity c WHERE c.categoryName = :name ")
	CategoryEntity findByCategoryNazwa(@Param("name") String name);
}
