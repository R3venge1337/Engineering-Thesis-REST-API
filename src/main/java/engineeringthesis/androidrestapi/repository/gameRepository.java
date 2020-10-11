package engineeringthesis.androidrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import engineeringthesis.androidrestapi.entity.GameEntity;

@Repository
public interface GameRepository extends JpaRepository<GameEntity,Integer> {

}
