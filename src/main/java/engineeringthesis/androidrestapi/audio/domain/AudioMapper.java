package engineeringthesis.androidrestapi.audio.domain;

import engineeringthesis.androidrestapi.audio.dto.AudioDTO;
import engineeringthesis.androidrestapi.common.entity.Mapper;
import org.springframework.stereotype.Component;

@Component
class AudioMapper implements Mapper<AudioDTO, Audio> {

    @Override
    public AudioDTO mapOfEntity(Audio entity) {

        AudioDTO audioDTO = AudioDTO.builder()
                .audioId(entity.getAudioId())
                .audioDownloadUri(entity.getAudioDownloadUri())
                .audioFileTable(entity.getAudioFileTable())
                .isAccepted(entity.isAccepted())
                .isNew(entity.isNew())
                .build();

        return audioDTO;
    }

    @Override
    public Audio mapOfDTO(AudioDTO dto) {

        Audio audioEntity = Audio.builder()
                .audioId(dto.getAudioId())
                .audioDownloadUri(dto.getAudioDownloadUri())
                .audioFileTable(dto.getAudioFileTable())
                .isAccepted(dto.isAccepted())
                .isNew(dto.isNew())
                .build();

        return audioEntity;
    }


}
