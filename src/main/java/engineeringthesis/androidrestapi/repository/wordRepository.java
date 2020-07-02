package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import engineeringthesis.androidrestapi.model.word;

@Repository
public interface wordRepository extends JpaRepository<word,Integer> {

}
