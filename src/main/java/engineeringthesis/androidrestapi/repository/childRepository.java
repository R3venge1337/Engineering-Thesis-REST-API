package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import engineeringthesis.androidrestapi.model.child;

@Repository
public interface childRepository extends JpaRepository<child,Integer> {

}
