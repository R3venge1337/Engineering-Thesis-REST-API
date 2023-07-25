package engineeringthesis.androidrestapi.account.domain;

import engineeringthesis.androidrestapi.common.repository.EmptyUuidInMemoryRepository;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryAccountRepository extends EmptyUuidInMemoryRepository<Account, Long> implements AccountRepository {

    private final ConcurrentHashMap<UUID, Account> map = new ConcurrentHashMap<>();

    @Override
    public Boolean existsByName(String name) {
        return map.entrySet().stream().anyMatch(c -> c.getValue().getName().equals(name));
    }

    @Override
    public Account save(final Account entity) {
        map.put(entity.getUuid(), entity);
        return entity;
    }

    @Override
    public Optional<Account> findByUuid(final UUID uuid) {
        return Optional.ofNullable(map.get(uuid));
    }

    @Override
    public Optional<Account> findByName(final String name) {
        return map.values().stream().filter(a -> a.getName().equals(name)).findFirst();
    }

    @Override
    public List<Account> findExpiredAccounts(final Integer expiredAge) {
        final int year = Year.now().getValue();

        return map.values().stream()
                .filter(account -> (account.getCreatedDate().getYear() - year % 2000) > expiredAge)
                .toList();
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        map.remove(uuid);
    }
}
