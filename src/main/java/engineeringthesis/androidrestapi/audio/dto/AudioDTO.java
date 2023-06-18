package engineeringthesis.androidrestapi.audio.dto;

import engineeringthesis.androidrestapi.audio.domain.AudioFileTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder
public class AudioDTO {
	
	private Integer audioId;
	
	private AudioFileTable audioFileTable;
	
	private String audioDownloadUri;
	
	private boolean isNew;
	
	private boolean isAccepted;
}
