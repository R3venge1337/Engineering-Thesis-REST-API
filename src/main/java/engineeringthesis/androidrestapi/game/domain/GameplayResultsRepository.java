package engineeringthesis.androidrestapi.game.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface GameplayResultsRepository extends JpaRepository<GameplayResult,Integer> {
	
	@Query("SELECT r FROM GameplayResultEntity r INNER JOIN GameplayEntity g ON r.gameplayId = g.gameplayId WHERE g.gameplayId = :gameplayId")
	List<GameplayResult>findByGameplayId(@Param("gameplayId") Integer gameplayId);
	
	
	@Query(value="SELECT * FROM gameplay_result\r\n"
			+ "	INNER JOIN gameplay ON gameplay_id_pk = gameplay_result.gameplay_id_fk\r\n"
			+ "	INNER JOIN statistic_result ON  statistic_result.statistic_result_id_pk =  gameplay_result.statistic_result_id_fk \r\n"
			+ "	INNER JOIN statistic ON statistic_id_pk = statistic_result.statistic_id_fk\r\n"
			+ "	INNER JOIN game ON game_id_pk = gameplay.game_id_fk \r\n"
			+ "	INNER JOIN category ON gameplay.category_id_fk = category.category_id_pk\r\n"
			+ "	INNER JOIN language ON language.language_id_pk = category.language_id_fk\r\n"
			+ "	WHERE quest_uuid_fk = :guestUUID ",nativeQuery = true)
	List<GameplayResult>getAllUserResultsByGuestId(@Param("guestUUID") String guestUUID);
	
	
	@Query(value="SELECT  * FROM gameplay_result\r\n"
			+ "	INNER JOIN gameplay ON gameplay_id_pk = gameplay_result.gameplay_id_fk\r\n"
			+ "	INNER JOIN statistic_result ON  statistic_result.statistic_result_id_pk =  gameplay_result.statistic_result_id_fk \r\n"
			+ "	INNER JOIN statistic ON statistic_id_pk = statistic_result.statistic_id_fk\r\n"
			+ "	INNER JOIN game ON  game.game_id_pk = gameplay.game_id_fk\r\n"
			+ "	INNER JOIN child ON child_quest_uuid = gameplay.quest_uuid_fk\r\n"
			+ "	WHERE game.game_name = :gameName ",nativeQuery = true)
	List<GameplayResult>getAllUserResultsByGameName(@Param("gameName") String gameName);
	
	
	
	
	
	
	
}
