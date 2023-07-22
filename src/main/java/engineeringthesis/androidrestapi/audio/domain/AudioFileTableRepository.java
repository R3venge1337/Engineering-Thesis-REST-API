package engineeringthesis.androidrestapi.audio.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface AudioFileTableRepository extends JpaRepository<AudioFileTable, Integer> {

    @Query("SELECT ntfs FROM AudioFileTable ntfs WHERE ntfs.audioFileTableName = :filename")
    AudioFileTable findByName(@Param("filename") final String filename);
}
