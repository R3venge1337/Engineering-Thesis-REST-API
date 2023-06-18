package engineeringthesis.androidrestapi.image.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
interface ImageFileTableRepository extends JpaRepository<ImageFileTable,Integer> {
	
	@Query("SELECT ntfs FROM ImageFileTableEntity ntfs WHERE ntfs.imageFileTableName = :filename")
	ImageFileTable findByName(@Param("filename") String filename);
}
