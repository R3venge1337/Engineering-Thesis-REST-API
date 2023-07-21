package engineeringthesis.androidrestapi.audio.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface AudioRepository extends UUIDAwareJpaRepository<Audio, Integer> {

    @Query("SELECT audio FROM Audio audio INNER JOIN audio.audioFileTable  WHERE audio.audioFileTable.audioFileTableName = :filename")
    Audio findByName(@Param("filename") final String filename);
}
