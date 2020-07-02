package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import engineeringthesis.androidrestapi.model.game;

@Repository
public interface gameRepository extends JpaRepository<game,Integer> {

}
