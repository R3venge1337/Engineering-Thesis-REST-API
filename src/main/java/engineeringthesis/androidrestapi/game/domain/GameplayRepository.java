package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface GameplayRepository extends UUIDAwareJpaRepository<Gameplay,Integer> {

}
