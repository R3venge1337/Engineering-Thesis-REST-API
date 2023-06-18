package engineeringthesis.androidrestapi.audio.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface AudioRepository extends JpaRepository<Audio, Integer> {

    @Query("SELECT audio FROM AudioEntity as audio INNER JOIN audio.audioFileTable  WHERE audio.audioFileTable.audioFileTableName = :filename")
    Audio findByName(@Param("filename") String filename);
}
