package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.model.image;

@Repository
public interface imageRepository extends JpaRepository<image,Integer> {

}
