package engineeringthesis.androidrestapi.image;

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
	
	private ImageFileTableEntity imageFileTable;
	
	private boolean isNew;
	
	private boolean isAccepted;
}
