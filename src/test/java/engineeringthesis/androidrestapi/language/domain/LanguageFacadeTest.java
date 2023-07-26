package engineeringthesis.androidrestapi.language.domain;

import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotUniqueException;
import engineeringthesis.androidrestapi.common.validation.ErrorDto;
import engineeringthesis.androidrestapi.common.validation.ValidationException;
import engineeringthesis.androidrestapi.common.validation.ValidationMessage;
import engineeringthesis.androidrestapi.language.LanguageFacade;
import engineeringthesis.androidrestapi.language.dto.CreateLanguageForm;
import engineeringthesis.androidrestapi.language.dto.LanguageDto;
import engineeringthesis.androidrestapi.language.dto.UpdateLanguageForm;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LanguageFacadeTest {

    private final LanguageRepository languageRepository = new InMemoryLanguageRepository();

    private final LanguageFacade languageFacade = new LanguageConfiguration().languageFacade(languageRepository);

    @Nested
    class Find {
        @Test
        void shouldThrowNotFound() {
            //given
            final UUID uuid = UUID.randomUUID();

            //when //then
            assertThrows(NotFoundException.class, () -> languageFacade.findLanguage(uuid));
        }

        @Test
        void shouldReturnWhenFound() {
            //given
            final Language language = createLanguageWithName();

            //when
            final LanguageDto returnedLanguage = languageFacade.findLanguage(language.getUuid());

            //then
            assertEquals(language.getUuid(), returnedLanguage.uuid());
        }
    }

    @Nested
    class Create {
        @Test
        void shouldThrowValidationException() {
            //given
            final CreateLanguageForm languageForm = IncorrectCreateLanguageForm();
            //when
            final ValidationException exception =
                    catchThrowableOfType(() -> languageFacade.saveLanguage(languageForm), ValidationException.class);

            //then
            assertThat(exception.getErrorDtos())
                    .containsExactlyInAnyOrder(
                            new ErrorDto("name", ValidationMessage.MUST_NOT_BE_BLANK)
                    );
        }

        @Test
        void shouldThrowNotUniqueException() {
            //given
            final CreateLanguageForm languageForm = createLanguageForm();
            createLanguageWithName();

            //when
            //trying to run create with same user
            final NotUniqueException exception =
                    catchThrowableOfType(() -> languageFacade.saveLanguage(languageForm), NotUniqueException.class);

            //then
            assertThat(exception).isInstanceOf(NotUniqueException.class);
        }

        @Test
        void shouldSave() {
            //given
            final CreateLanguageForm languageForm = createLanguageForm();
            createLanguageForm();

            //when
            final UuidDto uuidDto = languageFacade.saveLanguage(languageForm);

            //then
            assertThat(languageFacade.findLanguage(uuidDto.uuid()))
                    .hasFieldOrPropertyWithValue(Language.Fields.name, languageForm.name());
        }
    }

    @Nested
    class Update {
        @Test
        void shouldThrowValidationException() {
            //given
            final UpdateLanguageForm languageForm = IncorrectUpdateLanguageForm();

            //when
            final ValidationException exception =
                    catchThrowableOfType(() -> languageFacade.updateLanguage(UUID.randomUUID(), languageForm), ValidationException.class);

            //then
            assertThat(exception.getErrorDtos())
                    .containsExactlyInAnyOrder(
                            new ErrorDto("name", ValidationMessage.MUST_NOT_BE_BLANK)
                    );
        }

        @Test
        void shouldThrowNotFoundException() {
            //given
            final UpdateLanguageForm updateLanguageForm = updateLanguageForm();

            //when
            final NotFoundException exception =
                    catchThrowableOfType(() -> languageFacade.updateLanguage(UUID.randomUUID(), updateLanguageForm), NotFoundException.class);

            //then
            assertThat(exception).isInstanceOf(NotFoundException.class);
        }

        @Test
        void shouldUpdateWithSameName() {
            //given
            final CreateLanguageForm createForm = new CreateLanguageForm("English");
            final UpdateLanguageForm updateForm = new UpdateLanguageForm("English");
            final UuidDto uuidDto = languageFacade.saveLanguage(createForm);

            //when
            languageFacade.updateLanguage(uuidDto.uuid(), updateForm);

            //then
            assertThat(languageFacade.findLanguage(uuidDto.uuid()))
                    .hasFieldOrPropertyWithValue(Language.Fields.name, updateForm.name());
        }

        @Test
        void shouldUpdate() {
            //given
            final CreateLanguageForm createForm = createLanguageForm();
            final UpdateLanguageForm updateForm = updateLanguageForm();
            final UuidDto uuidDto = languageFacade.saveLanguage(createForm);

            //when
            languageFacade.updateLanguage(uuidDto.uuid(), updateForm);

            //then
            assertThat(languageFacade.findLanguage(uuidDto.uuid()))
                    .hasFieldOrPropertyWithValue(Language.Fields.name, updateForm.name());
        }
    }

    @Nested
    class Delete {
        @Test
        void shouldDeleteUser() {
            //given
            final CreateLanguageForm languageForm = createLanguageForm();
            final UuidDto uuidDto = languageFacade.saveLanguage(languageForm);

            //when
            languageFacade.deleteLanguage(uuidDto.uuid());

            final NotFoundException exception =
                    catchThrowableOfType(() -> languageFacade.findLanguage(uuidDto.uuid()), NotFoundException.class);
            // then
            assertThat(exception).isInstanceOf(NotFoundException.class);
        }
    }

    private CreateLanguageForm createLanguageForm() {
        return new CreateLanguageForm("English");
    }

    private CreateLanguageForm IncorrectCreateLanguageForm() {
        return new CreateLanguageForm("");
    }

    private UpdateLanguageForm updateLanguageForm() {
        return new UpdateLanguageForm("English");
    }

    private UpdateLanguageForm IncorrectUpdateLanguageForm() {
        return new UpdateLanguageForm("");
    }

    private Language createLanguageWithName() {
        final Language language = languageRepository.save(new Language());
        language.setName("English");

        return language;
    }
}
