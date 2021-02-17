package engineeringthesis.androidrestapi.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ntfs_audio")
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AudioFileTableEntity {
	
	@Id
	 @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
	 @GeneratedValue(generator = "generator")
	 @Column(name = "stream_id" , columnDefinition="uniqueidentifier")
	private String streamId;
	
	@Column(name = "file_stream" , columnDefinition="uniqueidentifier")
	private byte[] fileStream;
	
	@Column(name = "name",columnDefinition = "NVARCHAR")
	private String audioFileTableName;
	
	@Column(name = "path_locator",columnDefinition = "VARBINARY")
	private Byte[] pathLocator;
	
	@Column(name = "parent_path_locator",columnDefinition = "VARBINARY")
	private Byte[] parentPathLocator;
	
	@Column(name = "file_type",columnDefinition = "NVARCHAR")
	private String fileType;
	
	@Column(name = "cached_file_size")
	private Long cachedFileSize;
	
	@Column(name = "creation_time",columnDefinition = "datetimeoffset")
	@JsonSerialize(using = OffsetDateTimeSerializer.class) 
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX", iso = ISO.DATE_TIME)
	private OffsetDateTime creationTime;	
	
	@Column(name = "last_write_time",columnDefinition = "datetimeoffset")
	@JsonSerialize(using = OffsetDateTimeSerializer.class) 
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX", iso = ISO.DATE_TIME)
	private OffsetDateTime lastWriteTime;	
	
	@Column(name = "last_access_time",columnDefinition = "datetimeoffset")
	@JsonSerialize(using = OffsetDateTimeSerializer.class) 
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX", iso = ISO.DATE_TIME)
	private OffsetDateTime lastAccessTime;
	
	
	@Column(name = "is_directory", columnDefinition="BIT")
	private boolean isNew;
	
	@Column(name = "is_offline", columnDefinition="BIT")
	private boolean isOffline;
	
	@Column(name = "is_hidden", columnDefinition="BIT")
	private boolean isHidden;
	
	@Column(name = "is_readonly", columnDefinition="BIT")
	private boolean isReadonly;
	
	@Column(name = "is_archive", columnDefinition="BIT")
	private boolean isArchive;
	
	@Column(name = "is_system", columnDefinition="BIT")
	private boolean isSystem;
	
	@Column(name = "is_temporary", columnDefinition="BIT")
	private boolean isTemporary;
}
