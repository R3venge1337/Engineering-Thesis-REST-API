package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.AudioEntity;

@Repository
public interface AudioRepository extends JpaRepository<AudioEntity,Integer> {
	
	@Query("SELECT audio FROM AudioEntity as audio INNER JOIN audio.audioFileTable  WHERE audio.audioFileTable.audioFileTableName = :filename")
	AudioEntity findByName(@Param("filename") String filename);
}
