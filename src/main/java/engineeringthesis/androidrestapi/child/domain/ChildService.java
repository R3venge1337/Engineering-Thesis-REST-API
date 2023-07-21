package engineeringthesis.androidrestapi.child.domain;

import engineeringthesis.androidrestapi.child.ChildFacade;
import engineeringthesis.androidrestapi.child.dto.ChildDto;
import engineeringthesis.androidrestapi.child.dto.CreateChildForm;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class ChildService implements ChildFacade {


    private final ChildRepository childRepository;

    @Override
    public List<ChildDto> getAllChild() {
        return childRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public ChildDto saveChild(final CreateChildForm childForm) {

        final Child childEntity = new Child();
        childEntity.setName(childForm.childName());
        childEntity.setSurname(childForm.childSurname());
        childEntity.setYearOfBirth(childForm.childYearBirth());
        childEntity.setCity(childForm.childCity());

        final Child savedEntity = childRepository.save(childEntity);
        return mapToDto(savedEntity);
    }

    @Override
    public ChildDto getOneByName(final String name) {
        return null;
    }

    @Override
    @Transactional
    public ChildDto updateChild(final UUID uuid, final CreateChildForm childForm) {

        final Child childEntity = childRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

        childEntity.setName(childForm.childName());
        childEntity.setSurname(childForm.childSurname());
        childEntity.setCity(childForm.childCity());
        childEntity.setYearOfBirth(childForm.childYearBirth());

        childRepository.save(childEntity);

        return mapToDto(childEntity);
    }

    @Override
    @Transactional
    public void deleteChild(final UUID uuid) {
        childRepository.deleteByUuid(uuid);
    }

    @Override
    public ChildDto getChildWithAccount(final UUID uuid, final String accountName) {
        return mapToDto(childRepository.getChildWithAccount(accountName));
    }

    ChildDto mapToDto(final Child child) {
        return new ChildDto(child.getUuid(), child.getName(), child.getSurname(), child.getYearOfBirth(), child.getCity(), null);
    }
}
