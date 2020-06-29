package engineeringthesis.androidrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.model.category;

@Repository
public interface categoryRepository extends JpaRepository<category,Integer> {
	
	@Query("SELECT c FROM category c INNER JOIN language l ON c.languageId = l.languageId WHERE l.languageName = :languageName ")
	List<category> getCategoriesByLanguage(@Param("languageName") String languageName);
	
	@Query("SELECT c FROM category c WHERE c.categoryName = :name ")
	category findByCategoryNazwa(@Param("name")String name);
}
