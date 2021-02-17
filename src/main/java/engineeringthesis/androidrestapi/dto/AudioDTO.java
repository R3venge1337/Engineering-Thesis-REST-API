package engineeringthesis.androidrestapi.dto;

import engineeringthesis.androidrestapi.entity.AudioFileTableEntity;
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
	
	private AudioFileTableEntity audioFileTableEntity;
	
	private String audioDownloadUri;
	
	private boolean isNew;
	
	private boolean isAccepted;
}
