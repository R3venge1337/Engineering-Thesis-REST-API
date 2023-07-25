package engineeringthesis.androidrestapi.account.domain;

import engineeringthesis.androidrestapi.account.AccountFacade;
import engineeringthesis.androidrestapi.account.dto.AccountDto;
import engineeringthesis.androidrestapi.account.dto.AccountRoleDto;
import engineeringthesis.androidrestapi.account.dto.CreateAccountForm;
import engineeringthesis.androidrestapi.account.dto.UpdateAccountForm;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotUniqueException;
import engineeringthesis.androidrestapi.common.validation.ErrorDto;
import engineeringthesis.androidrestapi.common.validation.ValidationException;
import engineeringthesis.androidrestapi.common.validation.ValidationMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextBoolean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class AccountFacadeTest {
    private final AccountRepository accountRepository = new InMemoryAccountRepository();
    private final AccountRoleRepository accountRoleRepository = new InMemoryAccountRoleRepository();
    private final PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
    private final AccountFacade accountFacade = new AccountConfiguration().accountFacade(accountRepository, accountRoleRepository, passwordEncoder);

    @Nested
    class Find {
        @Test
        void shouldThrowNotFound() {
            //given
            final String accountName = "adamczyk97";

            //when //then
            assertThrows(NotFoundException.class, () -> accountFacade.findAccount(accountName));
        }

        @Test
        void shouldReturnWhenFound() {
            //given
            final CreateAccountForm accountForm = createAccountForm();
            final AccountRole accountRole = createAccountRoleWithName();
            final Account account = createAccountWithName();
            account.setRole(accountRole);

            //when
            final AccountDto returnedAccount = accountFacade.findAccount(accountForm.name());

            //then
            assertEquals(account.getUuid(), returnedAccount.uuid());
        }
    }

    @Nested
    class Create {
        @Test
        void shouldThrowValidationException() {
            //given
            final CreateAccountForm accountForm = IncorrectCreateAccountForm();
            //when
            final ValidationException exception =
                    catchThrowableOfType(() -> accountFacade.saveAccount(accountForm), ValidationException.class);

            //then
            assertThat(exception.getErrorDtos())
                    .containsExactlyInAnyOrder(
                            new ErrorDto("name", ValidationMessage.MUST_NOT_BE_BLANK),
                            new ErrorDto("password", ValidationMessage.MUST_NOT_BE_BLANK),
                            new ErrorDto("email", ValidationMessage.MUST_NOT_BE_BLANK),
                            new ErrorDto("active", ValidationMessage.MUST_NOT_BE_NULL),
                            new ErrorDto("role", ValidationMessage.MUST_NOT_BE_NULL)
                    );
        }

        @Test
        void shouldThrowNotUniqueException() {
            //given
            final CreateAccountForm accountForm = createAccountForm();
            createAccountWithName();

            //when
            //trying to run create with same user
            final NotUniqueException exception =
                    catchThrowableOfType(() -> accountFacade.saveAccount(accountForm), NotUniqueException.class);

            //then
            assertThat(exception).isInstanceOf(NotUniqueException.class);
        }

        @Test
        void shouldSave() {
            //given
            final CreateAccountForm accountForm = createAccountForm();
            createAccountRoleWithName();

            //when
            accountFacade.saveAccount(accountForm);

            //then
            assertThat(accountFacade.findAccount(accountForm.name()))
                    .hasFieldOrPropertyWithValue(Account.Fields.name, accountForm.name())
                    .hasFieldOrPropertyWithValue(Account.Fields.email, accountForm.email())
                    .hasFieldOrPropertyWithValue(Account.Fields.role, accountForm.role().name())
                    .hasFieldOrPropertyWithValue(Account.Fields.isActive, accountForm.active());
        }
    }

    @Nested
    class Update {
        @Test
        void shouldThrowValidationException() {
            //given
            final UpdateAccountForm accountForm = IncorrectUpdateAccountForm();

            //when
            final ValidationException exception =
                    catchThrowableOfType(() -> accountFacade.updateAccount(UUID.randomUUID(), accountForm), ValidationException.class);

            //then
            assertThat(exception.getErrorDtos())
                    .containsExactlyInAnyOrder(
                            new ErrorDto("name", ValidationMessage.MUST_NOT_BE_BLANK),
                            new ErrorDto("password", ValidationMessage.MUST_NOT_BE_BLANK),
                            new ErrorDto("email", ValidationMessage.MUST_NOT_BE_BLANK),
                            new ErrorDto("role", ValidationMessage.MUST_NOT_BE_NULL),
                            new ErrorDto("active", ValidationMessage.MUST_NOT_BE_NULL)
                    );
        }

        @Test
        void shouldThrowNotFoundException() {
            //given
            final UpdateAccountForm updateAccountForm = updateAccountForm();

            //when
            final NotFoundException exception =
                    catchThrowableOfType(() -> accountFacade.updateAccount(UUID.randomUUID(), updateAccountForm), NotFoundException.class);

            //then
            assertThat(exception).isInstanceOf(NotFoundException.class);
        }

        @Test
        void shouldUpdateWithSameName() {
            //given
            createAccountRoleWithName();
            final CreateAccountForm createForm = new CreateAccountForm("adamczyk97", "test", createEmail(), true, new AccountRoleDto("ROLE_ADMIN"));
            final UpdateAccountForm updateForm = new UpdateAccountForm("adamczyk97", "test", createEmail(), true, new AccountRoleDto("ROLE_ADMIN"));
            final AccountDto accountDto = accountFacade.saveAccount(createForm);

            //when
            accountFacade.updateAccount(accountDto.uuid(), updateForm);

            //then
            assertThat(accountFacade.findAccount(updateForm.name()))
                    .hasFieldOrPropertyWithValue(Account.Fields.name, updateForm.name())
                    .hasFieldOrPropertyWithValue(Account.Fields.role, updateForm.role().name())
                    .hasFieldOrPropertyWithValue(Account.Fields.isActive, updateForm.active());
        }

        @Test
        void shouldUpdate() {
            //given
            createAccountRoleWithName();
            final CreateAccountForm createAccountForm = createAccountForm();
            final UpdateAccountForm updateAccountForm = updateAccountForm();
            final AccountDto accountDto = accountFacade.saveAccount(createAccountForm);

            //when
            accountFacade.updateAccount(accountDto.uuid(), updateAccountForm);

            //then
            assertThat(accountFacade.findAccount(updateAccountForm.name()))
                    .hasFieldOrPropertyWithValue(Account.Fields.name, updateAccountForm.name())
                    .hasFieldOrPropertyWithValue(Account.Fields.role, updateAccountForm.role().name())
                    .hasFieldOrPropertyWithValue(Account.Fields.isActive, updateAccountForm.active());
        }
    }

    @Nested
    class Delete {
        @Test
        void shouldDeleteUser() {
            //given
            createAccountRoleWithName();
            final CreateAccountForm accountForm = createAccountForm();
            final AccountDto accountDto = accountFacade.saveAccount(accountForm);

            //when
            accountFacade.deleteAccount(accountDto.uuid());

            final NotFoundException exception =
                    catchThrowableOfType(() -> accountFacade.findAccount(accountDto.name()), NotFoundException.class);
            // then
            assertThat(exception).isInstanceOf(NotFoundException.class);
        }
    }

    private CreateAccountForm createAccountForm() {
        return new CreateAccountForm("adamczyk97", createPassword(), createEmail(), nextBoolean(), new AccountRoleDto("ROLE_ADMIN"));
    }

    private CreateAccountForm IncorrectCreateAccountForm() {
        return new CreateAccountForm("", "", "", null, null);
    }

    private UpdateAccountForm updateAccountForm() {
        return new UpdateAccountForm("adamczyk97", createPassword(), createEmail(), nextBoolean(), new AccountRoleDto("ROLE_ADMIN"));
    }

    private UpdateAccountForm IncorrectUpdateAccountForm() {
        return new UpdateAccountForm("", "", "", null, null);
    }

    private String createEmail() {
        return randomAlphabetic(10) + "@" + "test.com";
    }

    private AccountRole createAccountRoleWithName() {
        final AccountRole role = accountRoleRepository.save(new AccountRole());
        role.setName("ROLE_ADMIN");
        return role;
    }

    private Account createAccountWithName() {
        final Account account = accountRepository.save(new Account());
        account.setName("adamczyk97");
        return account;
    }

    private static String createPassword() {
        return randomAlphabetic(10);
    }

}
