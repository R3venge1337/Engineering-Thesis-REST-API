package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.GameplayEntity;

@Repository
public interface GameplayRepository extends JpaRepository<GameplayEntity,Integer> {

}
