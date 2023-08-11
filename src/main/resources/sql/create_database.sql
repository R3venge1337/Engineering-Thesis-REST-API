USE master;
GO

-- Create the database
CREATE DATABASE BazaPracaInzV2;
GO

USE BazaPracaInzV2;
GO

-- Enable FileStream
EXEC sp_configure 'show advanced options', 1;
RECONFIGURE;
GO

EXEC sp_configure 'filestream access level', 2;
RECONFIGURE;
GO

-- Create a dedicated FileStream filegroup
ALTER DATABASE BazaPracaInzV2
ADD FILEGROUP FileStreamGroup CONTAINS FILESTREAM;
GO

-- Create a FileStream file
ALTER DATABASE BazaPracaInzV2
ADD FILE (
    NAME = FileStreamData,
    FILENAME = '/var/opt/mssql/filestream_data'
)
TO FILEGROUP FileStreamGroup;
GO