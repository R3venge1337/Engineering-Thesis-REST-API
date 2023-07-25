package engineeringthesis.androidrestapi.account.domain;

import engineeringthesis.androidrestapi.common.repository.EmptyUuidInMemoryRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryAccountRoleRepository extends EmptyUuidInMemoryRepository<AccountRole, Long> implements AccountRoleRepository {
    private final ConcurrentHashMap<UUID, AccountRole> map = new ConcurrentHashMap<>();

    @Override
    public AccountRole save(AccountRole entity) {
        map.put(entity.getUuid(), entity);
        return entity;
    }

    @Override
    public Optional<AccountRole> findByUuid(UUID uuid) {
        return Optional.ofNullable(map.get(uuid));
    }

    @Override
    public Optional<AccountRole> findByName(String name) {
        return map.values().stream().filter(a -> a.getName().equals(name)).findFirst();
    }

}
