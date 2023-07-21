package engineeringthesis.androidrestapi.category.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

interface CategoryTeacherRepository extends JpaRepository<CategoryTeacher, Integer> {

    @Query("SELECT cat FROM CategoryTeacher cat INNER JOIN cat.category c " +
            " INNER JOIN cat.teacher t " + " WHERE t.uuid = :uuid")
    List<CategoryTeacher> getCategoriesTeacher(final UUID uuid);


}
