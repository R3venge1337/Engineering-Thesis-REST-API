package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.model.teacher;

@Repository
public interface teacherRepository  extends JpaRepository<teacher,Integer>{

}
