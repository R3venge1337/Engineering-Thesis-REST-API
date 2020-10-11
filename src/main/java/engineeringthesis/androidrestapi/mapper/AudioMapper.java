package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.AudioDTO;
import engineeringthesis.androidrestapi.entity.AudioEntity;

@Component
public class AudioMapper  implements Mapper<AudioDTO,AudioEntity>{

	@Override
	public AudioDTO mapOfEntity(AudioEntity entity) {
		
		AudioDTO audioDTO =  AudioDTO.builder()
				.ntfsAudioFileId(entity.getNtfsAudioFileId())
				.wordId(entity.getWordId())
				.isAccepted(entity.isAccepted())
				.isNew(entity.isNew())
				.build();
		
		return audioDTO;
	}

	@Override
	public AudioEntity mapOfDTO(AudioDTO dto) {
		
		AudioEntity audioEntity = AudioEntity.builder()
				.ntfsAudioFileId(dto.getNtfsAudioFileId())
				.wordId(dto.getWordId())
				.isAccepted(dto.isAccepted())
				.isNew(dto.isNew())
				.build();
		
		return audioEntity;
	}

	

}
