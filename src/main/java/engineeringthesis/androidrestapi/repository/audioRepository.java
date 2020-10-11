package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.AudioEntity;

@Repository
public interface AudioRepository extends JpaRepository<AudioEntity,Integer> {

}
