package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.WordEntity;

@Repository
public interface WordRepository extends JpaRepository<WordEntity,Integer> {

}
