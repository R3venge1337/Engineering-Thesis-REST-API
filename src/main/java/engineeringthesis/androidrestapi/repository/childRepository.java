package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.ChildEntity;

@Repository
public interface ChildRepository extends JpaRepository<ChildEntity,Integer> {

}
