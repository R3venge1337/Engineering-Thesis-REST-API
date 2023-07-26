package engineeringthesis.androidrestapi.role.domain;

import engineeringthesis.androidrestapi.common.repository.EmptyUuidInMemoryRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryRoleRepository extends EmptyUuidInMemoryRepository<Role, Long> implements RoleRepository {
    private final ConcurrentHashMap<UUID, Role> map = new ConcurrentHashMap<>();

    @Override
    public Boolean existsByName(final String name) {
        return map.entrySet().stream().anyMatch(c -> c.getValue().getName().equals(name));
    }

    @Override
    public Optional<Role> findByUuid(final UUID uuid) {
        return Optional.ofNullable(map.get(uuid));
    }

    @Override
    public Role save(final Role entity) {
        map.put(entity.getUuid(), entity);
        return entity;
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        map.remove(uuid);
    }
}
