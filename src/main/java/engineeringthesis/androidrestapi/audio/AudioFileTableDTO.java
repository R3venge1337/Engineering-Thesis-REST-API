package engineeringthesis.androidrestapi.audio;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class AudioFileTableDTO {

	private String streamId;
	
	private byte[] fileStream;
	
	private String audioFileTableName;

	private Byte[] pathLocator;
	
	private Byte[] parentPathLocator;
	
	private String fileType;
	
	private Long cachedFileSize;
	
	private OffsetDateTime creationTime;	
	
	private OffsetDateTime lastWriteTime;	
	
	private OffsetDateTime lastAccessTime;	
	
	private boolean isNew;
	
	private boolean isOffline;

	private boolean isHidden;
	
	private boolean isReadonly;
	
	private boolean isArchive;
	
	private boolean isSystem;
	
	private boolean isTemporary;
}
