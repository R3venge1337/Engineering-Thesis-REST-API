package engineeringthesis.androidrestapi.dto;

import engineeringthesis.androidrestapi.entity.WordEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class AudioDTO {
	
	private Integer audioId;
	
	private String ntfsAudioFileId;
	
	private String audioDownloadUri;
	
	private WordEntity wordId;
	
	private boolean isNew;
	
	private boolean isAccepted;
}
