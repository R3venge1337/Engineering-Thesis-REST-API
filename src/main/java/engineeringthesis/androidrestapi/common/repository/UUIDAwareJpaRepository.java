package engineeringthesis.androidrestapi.common.repository;

import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface UUIDAwareJpaRepository<T extends AbstractUUIDEntity, ID> extends JpaRepository<T, ID> {
  Optional<T> findByUuid(final UUID uuid);

  boolean existsByUuid(final UUID uuid);

  void deleteByUuid(final UUID uuid);
}