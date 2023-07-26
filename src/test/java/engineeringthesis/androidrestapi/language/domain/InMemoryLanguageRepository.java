package engineeringthesis.androidrestapi.language.domain;

import engineeringthesis.androidrestapi.common.repository.EmptyUuidInMemoryRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryLanguageRepository extends EmptyUuidInMemoryRepository<Language, Long> implements LanguageRepository {

    private final ConcurrentHashMap<UUID, Language> map = new ConcurrentHashMap<>();

    @Override
    public Boolean existsByName(String name) {
        return map.entrySet().stream().anyMatch(c -> c.getValue().getName().equals(name));
    }

    @Override
    public Language save(final Language entity) {
        map.put(entity.getUuid(), entity);
        return entity;
    }

    @Override
    public Optional<Language> findByUuid(final UUID uuid) {
        return Optional.ofNullable(map.get(uuid));
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        map.remove(uuid);
    }
}
