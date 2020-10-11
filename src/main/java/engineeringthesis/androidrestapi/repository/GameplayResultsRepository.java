package engineeringthesis.androidrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.GameplayResultEntity;

@Repository
public interface GameplayResultsRepository extends JpaRepository<GameplayResultEntity,Integer> {
	
	@Query("SELECT r FROM GameplayResultEntity r INNER JOIN GameplayEntity g ON r.gameplayId = g.gameplayId WHERE g.gameplayId = :gameplayId")
	List<GameplayResultEntity>findByGameplayId(@Param("gameplayId") Integer gameplayId);
}
