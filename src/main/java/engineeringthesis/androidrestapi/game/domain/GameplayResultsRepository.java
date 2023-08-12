package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

interface GameplayResultsRepository extends UUIDAwareJpaRepository<GameplayResult, Long>, JpaSpecificationExecutor<GameplayResult> {

    @Query("SELECT r FROM GameplayResult r INNER JOIN r.gameplay g WHERE g.uuid = :uuid")
    Page<GameplayResult> findByGameplayUuid(@Param("uuid") final UUID uuid);


    @Query(value = "SELECT * FROM gameplay_result\r\n"
            + "	INNER JOIN gameplay ON gameplay_id_pk = gameplay_result.gameplay_id_fk\r\n"
            + "	INNER JOIN statistic_result ON  statistic_result.statistic_result_id_pk =  gameplay_result.statistic_result_id_fk \r\n"
            + "	INNER JOIN statistic ON statistic_id_pk = statistic_result.statistic_id_fk\r\n"
            + "	INNER JOIN game ON game_id_pk = gameplay.game_id_fk \r\n"
            + "	INNER JOIN category ON gameplay.category_id_fk = category.category_id_pk\r\n"
            + "	INNER JOIN language ON language.language_id_pk = category.language_id_fk\r\n"
            + "	WHERE quest_uuid_fk = :guestUUID ", nativeQuery = true)
    List<GameplayResult> getAllUserResultsByGuestId(@Param("guestUUID") final String guestUUID);


    @Query(value = "SELECT  * FROM gameplay_result\r\n"
            + "	INNER JOIN gameplay ON gameplay_id_pk = gameplay_result.gameplay_id_fk\r\n"
            + "	INNER JOIN statistic_result ON  statistic_result.statistic_result_id_pk =  gameplay_result.statistic_result_id_fk \r\n"
            + "	INNER JOIN statistic ON statistic_id_pk = statistic_result.statistic_id_fk\r\n"
            + "	INNER JOIN game ON  game.game_id_pk = gameplay.game_id_fk\r\n"
            + "	INNER JOIN child ON child_quest_uuid = gameplay.quest_uuid_fk\r\n"
            + "	WHERE game.name = :gameName ", nativeQuery = true)
    List<GameplayResult> getAllUserResultsByGameName(final String gameName);


}
