package engineeringthesis.androidrestapi.audio;

import engineeringthesis.androidrestapi.audio.dto.AudioDto;
import engineeringthesis.androidrestapi.audio.dto.AudioFilterForm;
import engineeringthesis.androidrestapi.audio.dto.UpdateAudioForm;
import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


public interface AudioFacade {

    PageDto<AudioDto> findAudios(final AudioFilterForm filterForm, final PageableRequest pageableRequest);

    AudioDto saveAudio(final MultipartFile file);

    AudioDto findAudio(final UUID uuid);

    void updateAudio(final UUID uuid, final UpdateAudioForm audioForm);

    void deleteAudio(final UUID uuid);

    Resource loadAudioAsResource(final String audioName);
}
