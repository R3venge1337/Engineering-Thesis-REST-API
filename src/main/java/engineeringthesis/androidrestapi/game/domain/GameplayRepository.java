package engineeringthesis.androidrestapi.game.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface GameplayRepository extends JpaRepository<Gameplay,Integer> {

}
