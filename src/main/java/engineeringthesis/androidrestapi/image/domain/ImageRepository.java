package engineeringthesis.androidrestapi.image.domain;


import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface ImageRepository extends UUIDAwareJpaRepository<Image, Integer>, JpaSpecificationExecutor<Image> {

    @Query("SELECT image FROM Image as image INNER JOIN image.imageFileTable  WHERE image.imageFileTable.imageFileTableName = :filename")
    Image findByName(@Param("filename") final String filename);
}
