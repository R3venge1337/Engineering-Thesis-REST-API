package engineeringthesis.androidrestapi.role.domain;


import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotUniqueException;
import engineeringthesis.androidrestapi.common.validation.ErrorDto;
import engineeringthesis.androidrestapi.common.validation.ValidationException;
import engineeringthesis.androidrestapi.common.validation.ValidationMessage;
import engineeringthesis.androidrestapi.role.RoleFacade;
import engineeringthesis.androidrestapi.role.dto.CreateRoleForm;
import engineeringthesis.androidrestapi.role.dto.RoleDto;
import engineeringthesis.androidrestapi.role.dto.UpdateRoleForm;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoleFacadeTest {

    private final RoleRepository roleRepository = new InMemoryRoleRepository();

    private final RoleFacade roleFacade = new RoleConfiguration().roleFacade(roleRepository);

    @Nested
    class Find {
        @Test
        void shouldThrowNotFound() {
            //given
            final UUID uuid = UUID.randomUUID();

            //when //then
            assertThrows(NotFoundException.class, () -> roleFacade.findRole(uuid));
        }

        @Test
        void shouldReturnWhenFound() {
            //given
            final Role role = createRoleWithName();

            //when
            final RoleDto returnedRole = roleFacade.findRole(role.getUuid());

            //then
            assertEquals(role.getUuid(), returnedRole.uuid());
        }
    }

    @Nested
    class Create {
        @Test
        void shouldThrowValidationException() {
            //given
            final CreateRoleForm roleForm = IncorrectCreateRoleForm();

            //when
            final ValidationException exception =
                    catchThrowableOfType(() -> roleFacade.saveRole(roleForm), ValidationException.class);

            //then
            assertThat(exception.getErrorDtos())
                    .containsExactlyInAnyOrder(
                            new ErrorDto("name", ValidationMessage.MUST_NOT_BE_BLANK)
                    );
        }

        @Test
        void shouldThrowNotUniqueException() {
            //given
            final CreateRoleForm roleForm = createRoleForm();
            createRoleWithName();

            //when
            //trying to run create with same role
            final NotUniqueException exception =
                    catchThrowableOfType(() -> roleFacade.saveRole(roleForm), NotUniqueException.class);

            //then
            assertThat(exception).isInstanceOf(NotUniqueException.class);
        }

        @Test
        void shouldSave() {
            //given
            final CreateRoleForm roleForm = createRoleForm();

            //when
            final UuidDto uuidDto = roleFacade.saveRole(createRoleForm());

            //then
            assertThat(roleFacade.findRole(uuidDto.uuid()))
                    .hasFieldOrPropertyWithValue(Role.Fields.name, roleForm.name());
        }
    }

    @Nested
    class Update {
        @Test
        void shouldThrowValidationException() {
            //given
            final UpdateRoleForm accountForm = IncorrectUpdateRoleForm();

            //when
            final ValidationException exception =
                    catchThrowableOfType(() -> roleFacade.updateRole(UUID.randomUUID(), accountForm), ValidationException.class);

            //then
            assertThat(exception.getErrorDtos())
                    .containsExactlyInAnyOrder(
                            new ErrorDto("name", ValidationMessage.MUST_NOT_BE_BLANK)
                    );
        }

        @Test
        void shouldThrowNotFoundException() {
            //given
            final UpdateRoleForm updateRoleForm = updateRoleForm();

            //when
            final NotFoundException exception =
                    catchThrowableOfType(() -> roleFacade.updateRole(UUID.randomUUID(), updateRoleForm), NotFoundException.class);

            //then
            assertThat(exception).isInstanceOf(NotFoundException.class);
        }


        @Test
        void shouldUpdateWithSameName() {
            //given
            final CreateRoleForm roleForm = createRoleForm();
            final UuidDto uuidDto = roleFacade.saveRole(roleForm);
            final UpdateRoleForm updateRoleSame = new UpdateRoleForm("ROLE_ADMIN");

            //when
            roleFacade.updateRole(uuidDto.uuid(), updateRoleSame);

            //then
            assertThat(roleFacade.findRole(uuidDto.uuid()))
                    .hasFieldOrPropertyWithValue(Role.Fields.name, updateRoleSame.name());
        }

        @Test
        void shouldUpdate() {
            //given
            final CreateRoleForm roleForm = createRoleForm();
            final UuidDto uuidDto = roleFacade.saveRole(roleForm);
            final UpdateRoleForm updateRoleSame = new UpdateRoleForm("ROLE_ADMIN");

            //when
            roleFacade.updateRole(uuidDto.uuid(), updateRoleSame);

            //then
            assertThat(roleFacade.findRole(uuidDto.uuid()))
                    .hasFieldOrPropertyWithValue(Role.Fields.name, updateRoleSame.name());
        }
    }

    @Nested
    class Delete {
        @Test
        void shouldDeleteRole() {
            //given
            final CreateRoleForm roleForm = createRoleForm();
            final UuidDto uuidDto = roleFacade.saveRole(roleForm);

            //when
            roleFacade.deleteRole(uuidDto.uuid());

            final NotFoundException exception =
                    catchThrowableOfType(() -> roleFacade.findRole(uuidDto.uuid()), NotFoundException.class);
            // then
            assertThat(exception).isInstanceOf(NotFoundException.class);
        }
    }

    private Role createRoleWithName() {
        final Role role = roleRepository.save(new Role());
        role.setName("ROLE_ADMIN");
        return role;
    }

    private CreateRoleForm createRoleForm() {
        return new CreateRoleForm("ROLE_ADMIN");
    }

    private CreateRoleForm IncorrectCreateRoleForm() {
        return new CreateRoleForm("");
    }

    private UpdateRoleForm updateRoleForm() {
        return new UpdateRoleForm("ROLE_ADMIN");
    }

    private UpdateRoleForm IncorrectUpdateRoleForm() {
        return new UpdateRoleForm("");
    }
}
