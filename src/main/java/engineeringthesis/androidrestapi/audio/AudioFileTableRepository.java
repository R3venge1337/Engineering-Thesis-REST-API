package engineeringthesis.androidrestapi.audio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AudioFileTableRepository extends JpaRepository<AudioFileTableEntity,Integer> {
	
	@Query("SELECT ntfs FROM AudioFileTableEntity ntfs WHERE ntfs.audioFileTableName = :filename")
	AudioFileTableEntity findByName(@Param("filename") String filename);
}
