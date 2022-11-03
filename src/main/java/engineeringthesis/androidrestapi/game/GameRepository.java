package engineeringthesis.androidrestapi.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity,Integer> {
	@Query("SELECT g FROM GameEntity g WHERE g.gameName = :gameName ")
	GameEntity findByGameName(@Param("gameName") String gameName);
}
