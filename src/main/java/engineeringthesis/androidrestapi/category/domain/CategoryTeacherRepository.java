package engineeringthesis.androidrestapi.category.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface CategoryTeacherRepository extends JpaRepository<CategoryTeacher,Integer> {
	
	@Query("SELECT cat FROM CategoryTeacherEntity cat INNER JOIN CategoryEntity c ON cat.categoryId = c.categoryId INNER JOIN TeacherEntity t"
			+ " ON cat.teacherId = t.teacherId WHERE t.teacherId = :teacherId")
	List<CategoryTeacher> getCategoriesTeacher(@Param("teacherId") Integer teacherId);
	

}
