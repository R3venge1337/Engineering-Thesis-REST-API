package engineeringthesis.androidrestapi.audio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends JpaRepository<AudioEntity,Integer> {
	
	@Query("SELECT audio FROM AudioEntity as audio INNER JOIN audio.audioFileTable  WHERE audio.audioFileTable.audioFileTableName = :filename")
	AudioEntity findByName(@Param("filename") String filename);
}
