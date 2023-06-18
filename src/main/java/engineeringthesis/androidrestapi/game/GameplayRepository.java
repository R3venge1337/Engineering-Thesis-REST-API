package engineeringthesis.androidrestapi.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameplayRepository extends JpaRepository<GameplayEntity,Integer> {

}
