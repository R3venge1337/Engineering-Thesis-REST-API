package engineeringthesis.androidrestapi.image.dto;

import java.time.OffsetDateTime;

public record ImageFileTableDto(String streamId, Byte[] fileStream, String imageFileTableName, Byte[] pathLocator,
                                Byte[] parentPathLocator, String fileType, Long cachedFileSize,
                                OffsetDateTime creationTime, OffsetDateTime lastWriteTime,
                                OffsetDateTime lastAccessTime, Boolean isNew, Boolean isOffline, Boolean isHidden,
                                Boolean isReadonly, Boolean isArchive, Boolean isSystem, Boolean isTemporary) {
}
