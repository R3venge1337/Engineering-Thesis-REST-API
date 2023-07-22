package engineeringthesis.androidrestapi.audio.dto;

import java.time.OffsetDateTime;

public record AudioFileTableDto(String streamId, Byte[] fileStream, String audioFileTableName, Byte[] pathLocator,
                                Byte[] parentPathLocator, String fileType, Long cachedFileSize,
                                OffsetDateTime creationTime, OffsetDateTime lastWriteTime,
                                OffsetDateTime lastAccessTime, Boolean isNew, Boolean isOffline, Boolean isHidden,
                                Boolean isReadonly, Boolean isArchive, Boolean isSystem, Boolean isTemporary) {
}
