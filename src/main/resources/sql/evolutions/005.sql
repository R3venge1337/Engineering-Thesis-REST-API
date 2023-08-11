--liquibase formatted sql
--changeset adam.zimny:5 labels:DEV
--------------------------------------------------------------------
----Konfiguracja FILESTREAM-----------------------------------------
--------------------------------------------------------------------
CREATE TABLE dbo.ntfs_image
AS FILETABLE
WITH
(
FILETABLE_DIRECTORY = N'Images',
FILETABLE_COLLATE_FILENAME = database_default
)
GO

CREATE TABLE dbo.ntfs_audio
AS FILETABLE
WITH
(
FILETABLE_DIRECTORY = N'Audio',
FILETABLE_COLLATE_FILENAME = database_default

)
GO

--rollback DROP TABLE dbo.ntfs_audio;
--rollback DROP TABLE dbo.ntfs_image;