package engineeringthesis.androidrestapi.game.domain;

import engineeringthesis.androidrestapi.common.repository.UUIDAwareJpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface GameRepository extends UUIDAwareJpaRepository<Game, Long>, JpaSpecificationExecutor<Game> {

    Boolean existsByName(final String name);
}
