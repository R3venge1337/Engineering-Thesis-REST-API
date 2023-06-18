package engineeringthesis.androidrestapi.image.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface ImageRepository extends JpaRepository<Image,Integer> {
	
	@Query("SELECT image FROM ImageEntity as image INNER JOIN image.imageFileTable  WHERE image.imageFileTable.imageFileTableName = :filename")
	Image findByName(@Param("filename") String filename);
}
