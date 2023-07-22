package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

interface GameRepository extends UUIDAwareJpaRepository<Game,Integer> {
	@Query("SELECT g FROM Game g WHERE g.name = :gameName")
    Game findByGameName(final String gameName);
}
