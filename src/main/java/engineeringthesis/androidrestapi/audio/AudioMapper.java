package engineeringthesis.androidrestapi.audio;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.util.Mapper;

@Component
public class AudioMapper  implements Mapper<AudioDTO,AudioEntity>{

	@Override
	public AudioDTO mapOfEntity(AudioEntity entity) {
		
		AudioDTO audioDTO =  AudioDTO.builder()
				.audioId(entity.getAudioId())
				.audioDownloadUri(entity.getAudioDownloadUri())
				.audioFileTableEntity(entity.getAudioFileTable())
				.isAccepted(entity.isAccepted())
				.isNew(entity.isNew())
				.build();
		
		return audioDTO;
	}

	@Override
	public AudioEntity mapOfDTO(AudioDTO dto) {
		
		AudioEntity audioEntity = AudioEntity.builder()
				.audioId(dto.getAudioId())
				.audioDownloadUri(dto.getAudioDownloadUri())
				.audioFileTable(dto.getAudioFileTableEntity())
				.isAccepted(dto.isAccepted())
				.isNew(dto.isNew())
				.build();
		
		return audioEntity;
	}

	

}
