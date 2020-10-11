package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import engineeringthesis.androidrestapi.entity.ImageFileTableEntity;

public interface ImageFileTableRepository extends JpaRepository<ImageFileTableEntity,Integer> {
	
	@Query("SELECT ntfs FROM ImageFileTableEntity ntfs WHERE ntfs.imageFileTableName = :filename")
	ImageFileTableEntity findByName(@Param("filename") String filename);
}
