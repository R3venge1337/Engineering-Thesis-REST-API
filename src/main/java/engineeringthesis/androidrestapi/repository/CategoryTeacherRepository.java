package engineeringthesis.androidrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.CategoryTeacherEntity;

@Repository
public interface CategoryTeacherRepository extends JpaRepository<CategoryTeacherEntity,Integer> {
	
	@Query("SELECT cat FROM CategoryTeacherEntity cat INNER JOIN CategoryEntity c ON cat.categoryId = c.categoryId INNER JOIN TeacherEntity t"
			+ " ON cat.teacherId = t.teacherId WHERE t.teacherId = :teacherId")
	List<CategoryTeacherEntity> getCategoriesTeacher(@Param("teacherId") Integer teacherId);
	

}
