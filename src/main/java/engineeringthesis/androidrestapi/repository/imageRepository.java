package engineeringthesis.androidrestapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import engineeringthesis.androidrestapi.entity.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity,Integer> {
	
	@Query("SELECT image FROM ImageEntity as image INNER JOIN image.imageFileTable  WHERE image.imageFileTable.imageFileTableName = :filename")
		ImageEntity findByName(@Param("filename") String filename);
}
