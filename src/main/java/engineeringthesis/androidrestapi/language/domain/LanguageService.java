package engineeringthesis.androidrestapi.language.domain;

import engineeringthesis.androidrestapi.common.exception.NotFoundException;
import engineeringthesis.androidrestapi.language.LanguageFacade;
import engineeringthesis.androidrestapi.language.dto.CreateLanguageForm;
import engineeringthesis.androidrestapi.language.dto.LanguageDto;
import engineeringthesis.androidrestapi.language.dto.UpdateLanguageForm;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class LanguageService implements LanguageFacade {

    private final LanguageRepository languageRepository;

    @Override
    public List<LanguageDto> getAllLanguage() {

        return languageRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public LanguageDto saveLanguage(final CreateLanguageForm languageForm) {

        Language language = new Language();
        language.setName(languageForm.name());
        language.setCreatedDate(LocalDateTime.now());

        return mapToDto(languageRepository.save(language));
    }

    @Override
    public LanguageDto findLanguage(final UUID uuid) {
        return languageRepository.findByUuid(uuid)
                .map(this::mapToDto)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    @Transactional
    public void deleteLanguage(final UUID uuid) {
        languageRepository.deleteByUuid(uuid);
    }

    @Override
    @Transactional
    public void updateLanguage(final UUID uuid, final UpdateLanguageForm languageForm) {
        Language language = languageRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException(""));

        language.setName(languageForm.name());
        //savedEntity.setLanguageImageIcon(lang.getLanguageImageIcon());
        language.setCreatedDate(languageForm.createdDate());
    }

    LanguageDto mapToDto(final Language language) {
        return new LanguageDto(language.getName(), language.getCreatedDate());
    }
}
