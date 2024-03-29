package engineeringthesis.androidrestapi.language;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.language.dto.CreateLanguageForm;
import engineeringthesis.androidrestapi.language.dto.LanguageDto;
import engineeringthesis.androidrestapi.language.dto.LanguageFilterForm;
import engineeringthesis.androidrestapi.language.dto.UpdateLanguageForm;

import java.util.UUID;

public interface LanguageFacade {

    PageDto<LanguageDto> findLanguages(final LanguageFilterForm filterForm, final PageableRequest pageableRequest);

    UuidDto saveLanguage(final CreateLanguageForm createForm);

    LanguageDto findLanguage(final UUID uuid);

    void updateLanguage(final UUID uuid, final UpdateLanguageForm createForm);

    void deleteLanguage(final UUID uuid);
}
