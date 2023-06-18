package engineeringthesis.androidrestapi.audio.domain;

import engineeringthesis.androidrestapi.audio.domain.AudioFileTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface AudioFileTableRepository extends JpaRepository<AudioFileTable,Integer> {
	
	@Query("SELECT ntfs FROM AudioFileTableEntity ntfs WHERE ntfs.audioFileTableName = :filename")
	AudioFileTable findByName(@Param("filename") String filename);
}
