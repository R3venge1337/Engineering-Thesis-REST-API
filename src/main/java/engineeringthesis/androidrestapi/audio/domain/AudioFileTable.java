package engineeringthesis.androidrestapi.audio.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JavaType;
import org.hibernate.type.descriptor.java.ByteArrayJavaType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.OffsetDateTime;

@Entity
@Table(name = "ntfs_audio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class AudioFileTable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "stream_id", columnDefinition = "uniqueidentifier")
    private String streamId;

    @Column(name = "file_stream", columnDefinition = "uniqueidentifier")
    @JavaType(ByteArrayJavaType.class)
    private Byte[] fileStream;

    @Column(name = "name", columnDefinition = "NVARCHAR")
    private String audioFileTableName;

    @Column(name = "path_locator", columnDefinition = "VARBINARY")
    @JavaType(ByteArrayJavaType.class)
    private Byte[] pathLocator;

    @Column(name = "parent_path_locator", columnDefinition = "VARBINARY")
    @JavaType(ByteArrayJavaType.class)
    private Byte[] parentPathLocator;

    @Column(name = "file_type", columnDefinition = "NVARCHAR")
    private String fileType;

    @Column(name = "cached_file_size")
    private Long cachedFileSize;

    @Column(name = "creation_time", columnDefinition = "datetimeoffset")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX", iso = ISO.DATE_TIME)
    private OffsetDateTime creationTime;

    @Column(name = "last_write_time", columnDefinition = "datetimeoffset")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX", iso = ISO.DATE_TIME)
    private OffsetDateTime lastWriteTime;

    @Column(name = "last_access_time", columnDefinition = "datetimeoffset")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX", iso = ISO.DATE_TIME)
    private OffsetDateTime lastAccessTime;


    @Column(name = "is_directory", columnDefinition = "BIT")
    private Boolean isNew;

    @Column(name = "is_offline", columnDefinition = "BIT")
    private Boolean isOffline;

    @Column(name = "is_hidden", columnDefinition = "BIT")
    private Boolean isHidden;

    @Column(name = "is_readonly", columnDefinition = "BIT")
    private Boolean isReadonly;

    @Column(name = "is_archive", columnDefinition = "BIT")
    private Boolean isArchive;

    @Column(name = "is_system", columnDefinition = "BIT")
    private Boolean isSystem;

    @Column(name = "is_temporary", columnDefinition = "BIT")
    private Boolean isTemporary;
}
