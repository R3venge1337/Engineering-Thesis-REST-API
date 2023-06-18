package engineeringthesis.androidrestapi.image.dto;

import engineeringthesis.androidrestapi.image.domain.ImageFileTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDTO {
	
	private Integer imageId;
	
	private String imageDownloadUri;
	
	private ImageFileTable imageFileTable;
	
	private boolean isNew;
	
	private boolean isAccepted;
}
