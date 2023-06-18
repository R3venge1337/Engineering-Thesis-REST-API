package engineeringthesis.androidrestapi.game.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface GameRepository extends JpaRepository<Game,Integer> {
	@Query("SELECT g FROM GameEntity g WHERE g.gameName = :gameName ")
    Game findByGameName(@Param("gameName") String gameName);
}
