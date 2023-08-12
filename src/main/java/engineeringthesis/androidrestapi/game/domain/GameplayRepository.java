package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface GameplayRepository extends UUIDAwareJpaRepository<Gameplay, Long>, JpaSpecificationExecutor<Gameplay> {

}
