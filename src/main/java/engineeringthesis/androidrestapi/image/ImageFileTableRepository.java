package engineeringthesis.androidrestapi.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageFileTableRepository extends JpaRepository<ImageFileTableEntity,Integer> {
	
	@Query("SELECT ntfs FROM ImageFileTableEntity ntfs WHERE ntfs.imageFileTableName = :filename")
	ImageFileTableEntity findByName(@Param("filename") String filename);
}
