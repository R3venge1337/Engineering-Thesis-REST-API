package engineeringthesis.androidrestapi.language.domain;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.PageableUtils;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.common.exception.NotUniqueException;
import engineeringthesis.androidrestapi.common.validation.DtoValidator;
import engineeringthesis.androidrestapi.language.LanguageFacade;
import engineeringthesis.androidrestapi.language.dto.CreateLanguageForm;
import engineeringthesis.androidrestapi.language.dto.LanguageDto;
import engineeringthesis.androidrestapi.language.dto.LanguageFilterForm;
import engineeringthesis.androidrestapi.language.dto.UpdateLanguageForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.UUID;

import static engineeringthesis.androidrestapi.language.domain.LanguageService.ErrorMessages.LANGUAGE_FOUND_BY_LOGIN;
import static engineeringthesis.androidrestapi.language.domain.LanguageService.ErrorMessages.LANGUAGE_NOT_EXIST;

@RequiredArgsConstructor
class LanguageService implements LanguageFacade {

    private final LanguageRepository languageRepository;

    static final class ErrorMessages {
        static final String LANGUAGE_NOT_EXIST = "Language not exist";
        static final String LANGUAGE_FOUND_BY_LOGIN = "Language was found";
    }

    @Override
    public PageDto<LanguageDto> findLanguages(final LanguageFilterForm filterForm, final PageableRequest pageableRequest) {
        DtoValidator.validate(filterForm);
        DtoValidator.validate(pageableRequest);

        final LanguageSpecification specification = new LanguageSpecification(filterForm);
        final Page<LanguageDto> languages = languageRepository.findAll(specification, PageableUtils.createPageable(pageableRequest))
                .map(this::mapToDto);

        return PageableUtils.toDto(languages);
    }

    @Override
    @Transactional
    public UuidDto saveLanguage(final CreateLanguageForm createForm) {
        DtoValidator.validate(createForm);
        checkUnique(createForm.name());

        final Language language = new Language();
        language.setName(createForm.name());
        language.setCreatedDate(LocalDateTime.now());

        return new UuidDto(languageRepository.save(language).getUuid());
    }

    @Override
    public LanguageDto findLanguage(final UUID uuid) {
        return languageRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(LANGUAGE_NOT_EXIST));
    }

    @Override
    @Transactional
    public void updateLanguage(final UUID uuid, final UpdateLanguageForm updateForm) {
        DtoValidator.validate(updateForm);

        final Language language = languageRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(LANGUAGE_NOT_EXIST, updateForm.name()));

        checkUnique(updateForm.name(), language.getName());

        language.setName(updateForm.name());
    }

    @Override
    @Transactional
    public void deleteLanguage(final UUID uuid) {
        languageRepository.deleteByUuid(uuid);
    }

    LanguageDto mapToDto(final Language language) {
        return new LanguageDto(language.getUuid(), language.getName(), language.getCreatedDate());
    }

    private void checkUnique(final String formLogin, final String entityLogin) {
        if (!formLogin.equals(entityLogin)) {
            checkUnique(formLogin);
        }
    }

    void checkUnique(final String login) {
        if (languageRepository.existsByName(login)) {
            throw new NotUniqueException(Language.Fields.name, LANGUAGE_FOUND_BY_LOGIN);
        }
    }
}
