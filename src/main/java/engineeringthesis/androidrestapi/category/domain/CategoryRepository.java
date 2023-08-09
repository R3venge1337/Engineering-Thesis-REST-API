package engineeringthesis.androidrestapi.category.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface CategoryRepository extends UUIDAwareJpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {

    @Query("SELECT c FROM Category c INNER JOIN c.language l WHERE l.name = :languageName ")
    List<Category> findCategoriesByLanguage(final String languageName);

    @Query("SELECT c FROM Category c WHERE c.name = :name ")
    Category findByCategoryName(final String name);
}
