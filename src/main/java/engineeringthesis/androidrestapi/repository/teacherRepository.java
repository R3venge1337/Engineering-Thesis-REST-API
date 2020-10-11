package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.TeacherEntity;

@Repository
public interface TeacherRepository  extends JpaRepository<TeacherEntity,Integer>{

}
