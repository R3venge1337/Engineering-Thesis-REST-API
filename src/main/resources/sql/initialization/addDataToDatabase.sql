--use BazaPracaInz
--GO
------------------------------------------------------------------------------
-- Dodanie plik�w do folderu Audio 
------------------------------------------------------------------------------
/*
INSERT INTO dbo.ntfs_audio
([name],[file_stream])
SELECT 'Original (requiem For A Dream) [Mp3glu.org].mp3',* FROM OPENROWSET(BULK N'D:\Rzeczy z pulpitu\Pendrive2\Original (requiem For A Dream) [Mp3glu.org].mp3', SINGLE_BLOB) AS FileData
GO
*/
 ------------------------------------------------------------------------------
-- Dodanie plik�w do folderu Images
------------------------------------------------------------------------------
/*
INSERT INTO dbo.ntfs_image
([name],[file_stream])
SELECT 'pilka.jpg',* FROM OPENROWSET(BULK N'D:\Studia\Praca inzynierska\Projektowanie UI\Grafika\pilka.jpg', SINGLE_BLOB) AS FileData
GO
*/
------------------------------------------------------------------------------
-- Procedury
------------------------------------------------------------------------------
--Resetowanie klucza generujacego
--DBCC CHECKIDENT ('role', RESEED, 0);
--GO

CREATE PROCEDURE dbo.selectImageFullPath 
@name nvarchar(50)
AS
	DECLARE @filetableroot varchar(256)
	DECLARE @filepath varchar(1000)

	SELECT @filetableroot = FileTableRootPath();

	SELECT @filepath = @filetableroot + file_stream.GetFileNamespacePath()
	FROM dbo.ntfs_image
	WHERE name = @name;

	PRINT @filepath
	GO
GO

--exec dbo.selectImageFullPath 'aerobics.jpg';
--GO

ALTER PROCEDURE dbo.addRole
@Par_id INT,
@Par_roleName VARCHAR(50)
AS
BEGIN
-- Generate a random UUID (version 4) using NEWID()
    DECLARE @uuid UNIQUEIDENTIFIER = NEWID();

	INSERT dbo.role
	(id, uuid, name,date_created)
	VALUES
	(@Par_id,@uuid,@Par_roleName,CONVERT(DATETIME,GETDATE(),103));
END
GO

exec dbo.addRole 1,'ROLE_ADMIN'
exec dbo.addRole 2,'ROLE_TEACHER'
exec dbo.addRole 3,'ROLE_CHILD'
GO

ALTER PROCEDURE dbo.addAccount
@Par_id INT,
@Par_accountName VARCHAR(50),
@Par_accountPassword VARCHAR(255),
@Par_accountEmail VARCHAR(50),
@Par_roleIdFK INT
AS
BEGIN
    -- Generate a random UUID (version 4) using NEWID()
    DECLARE @uuid UNIQUEIDENTIFIER = NEWID();

    INSERT dbo.account
	(id, uuid,name,password,date_created,email,is_active,role_id_fk)
	VALUES
	(@Par_id, @uuid,@Par_accountName,@Par_accountPassword,CONVERT(DATETIME,GETDATE(),103),@Par_accountEmail,1,@Par_roleIdFK);
END
GO

---password admin123!Z
exec dbo.addAccount 1,'admin','$2a$10$31cydj1.qtzugr1s5CNJveL9k5iX1PbmulhdG0G0kqPjUalKXDuFi','admin@wp.pl',1
GO

exec dbo.addAccount 2,'test','$2a$10$31cydj1.qtzugr1s5CNJveL9k5iX1PbmulhdG0G0kqPjUalKXDuFi','test@wp.pl',1
GO

CREATE  PROCEDURE dbo.addLanguage
@Par_id INT,
@Par_languageName VARCHAR(50),
@Par_isNew BIT,
@Par_isAccepted BIT
AS
BEGIN
    -- Generate a random UUID (version 4) using NEWID()
    DECLARE @uuid UNIQUEIDENTIFIER = NEWID();

	INSERT dbo.language
	(id, uuid, name,date_created,is_new,is_accepted)
	VALUES
	(@Par_id,@uuid, @Par_languageName,CONVERT(DATETIME,GETDATE(),103), @Par_isNew, @Par_isAccepted);
END
GO

exec dbo.addLanguage 1,'Angielski',0,0
GO

CREATE PROCEDURE dbo.addCategory
@Par_categoryName VARCHAR(50),
@Par_languageInt INT,
@Par_isNew BIT,
@Par_isAccepted BIT
AS
BEGIN
	INSERT dbo.category
	(name,language_id_fk,is_new,is_accepted)
	VALUES
	(@Par_categoryName ,@Par_languageInt,@Par_isNew,@Par_isAccepted);
END
GO

exec dbo.addCategory 'Sport',1,0,0
exec dbo.addCategory 'Zwierz�ta',1,0,0
GO

CREATE PROCEDURE dbo.addCategoryToTeacher
@Par_category_id_fk int,
@Par_teacher_id_fk int,
@Par_is_new bit,
@Par_is_accepted bit 
AS
BEGIN
	INSERT dbo.category_teacher
	(category_id_fk,teacher_id_fk,is_new,is_accepted)
	VALUES
	(@Par_category_id_fk ,@Par_teacher_id_fk,@Par_is_new,@Par_is_accepted);
END
GO

CREATE PROCEDURE dbo.addStatistic
@Par_statisticName VARCHAR(50),
@Par_isNew BIT,
@Par_isAccepted BIT
AS
BEGIN
	INSERT dbo.statistic
	(name,is_new,is_accepted)
	VALUES
	(@Par_statisticName,@Par_isNew,@Par_isAccepted);
END
GO

exec dbo.addStatistic 'Błędy',0,0
exec dbo.addStatistic 'Czas w rozgrywce',0,0
GO

CREATE  PROCEDURE dbo.addWord
@Par_wordName VARCHAR(50),
@Par_wordURL VARCHAR(100),
@Par_categoryIdFK INT,
@Par_languageIdFK INT,
@Par_imageIdFK INT,
@Par_audioIdFK INT,
@Par_isNew BIT,
@Par_isAccepted BIT
AS
BEGIN
	INSERT dbo.word
	(name,download_uri,category_id_fk,language_id_fk,image_id_fk,audio_id_fk,is_new,is_accepted)
	VALUES
	(@Par_wordName,@Par_wordURL,@Par_categoryIdFK,@Par_languageIdFK,@Par_imageIdFK,@Par_audioIdFK,@Par_isNew,@Par_isAccepted);
END
GO

CREATE  PROCEDURE dbo.addImage
@Par_ntfs_id_fk uniqueidentifier,
@Par_image_download_uri varchar(100),
@Par_isNew BIT,
@Par_isAccepted BIT
AS
BEGIN
	INSERT dbo.image
	(ntfs_image_id_fk,download_uri,is_new,is_accepted)
	VALUES
	(@Par_ntfs_id_fk,@Par_image_download_uri,@Par_isNew,@Par_isAccepted);
END
GO

CREATE  PROCEDURE dbo.addTeacher
@Par_teacher_name  varchar(60),
@Par_teacher_surname varchar(60),
@Par_teacher_profession varchar(100),
@Par_teacher_year_of_birth smallint,
@Par_teacher_city varchar(50),
@Par_language_id_fk int,
@Par_account_id_fk int
AS
BEGIN
	INSERT dbo.teacher
	(name,surname,profession,year_of_birth,city,language_id_fk,account_id_fk)
	VALUES
	(@Par_teacher_name,@Par_teacher_surname,@Par_teacher_profession,@Par_teacher_year_of_birth,@Par_teacher_city,@Par_language_id_fk,@Par_account_id_fk);
END
GO

CREATE  PROCEDURE dbo.addGame
@Par_gameName varchar(50),
@Par_isNew BIT,
@Par_isAccepted BIT
AS
BEGIN
	INSERT dbo.game
	(name,is_new,is_accepted)
	VALUES
	(@Par_gameName,@Par_isNew,@Par_isAccepted);
END
GO

CREATE  PROCEDURE dbo.addAudio
@Par_ntfs_id_fk uniqueidentifier,
@Par_audio_download_uri varchar(100),
@Par_isNew BIT,
@Par_isAccepted BIT
AS
BEGIN
	INSERT dbo.audio
	(ntfs_audio_id_fk,download_uri,is_new,is_accepted)
	VALUES
	(@Par_ntfs_id_fk,@Par_audio_download_uri,@Par_isNew,@Par_isAccepted);
END
GO
----------------------------------
-- Kategoria Sport
---------------------------------
DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'aerobics.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/aerobics.jpg',0,0
GO 

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'rugby.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/rugby.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'archery.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/archery.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'badminton.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/badminton.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'baseball.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/baseball.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'basketball.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/basketball.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'beachvolleyball.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/beachvolleyball.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'bowling.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/bowling.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'boxing.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/boxing.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'canoeing.jpg'
/*
DECLARE @idWordFK INT
SELECT @idWordFK = word_id_pk FROM word WHERE word_name = 'canoeing'
*/
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/canoeing.jpg',0,0
GO
------------------------------
-- Kategoria Sport
---------------------------------
------------------------------------------
--Dodanie kluczy do plik�w audio o sporcie
----------------------------------------
DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'aerobics.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/aerobics.m4a',0,0
GO 
DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'rugby.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/rugby.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'archery.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/archery.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'badminton.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/badminton.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'baseball.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/baseball.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'basketball.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/basketball.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'beachvolleyball.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/beachvolleyball.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'bowling.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/bowling.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'boxing.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/boxing.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'canoeing.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/canoeing.m4a',0,0
GO
-----------------------------------------
-- Przypisanie audio i zdjecia do slowa z kategorii Sport
-------------------------------------------
DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Sport'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'aerobics.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'aerobics.m4a'
PRINT @idimage
exec dbo.addWord 'aerobics','https://192.168.1.24/api/images/downloadFile/aerobicsWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Sport'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'rugby.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'rugby.m4a'
PRINT @idimage
exec dbo.addWord 'rugby','https://192.168.1.24/api/images/downloadFile/rugbyWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Sport'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'archery.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'archery.m4a'
PRINT @idimage
exec dbo.addWord 'archery','https://192.168.1.24/api/images/downloadFile/archeryWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO
DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Sport'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'badminton.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'badminton.m4a'
PRINT @idimage
exec dbo.addWord 'badminton','https://192.168.1.24/api/images/downloadFile/badmintonWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Sport'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'baseball.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'baseball.m4a'
PRINT @idimage
exec dbo.addWord 'baseball','https://192.168.1.24/api/images/downloadFile/baseballWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Sport'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'basketball.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'basketball.m4a'
PRINT @idimage
exec dbo.addWord 'basketball','https://192.168.1.24/api/images/downloadFile/basketballWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Sport'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'beachvolleyball.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'beachvolleyball.m4a'
PRINT @idimage
exec dbo.addWord 'beach volleyball','https://192.168.1.24/api/images/downloadFile/beachvolleyballWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Sport'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'bowling.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'bowling.m4a'
PRINT @idimage
exec dbo.addWord 'bowling','https://192.168.1.24/api/images/downloadFile/bowlingWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Sport'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'boxing.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'boxing.m4a'
PRINT @idimage
exec dbo.addWord 'boxing','https://192.168.1.24/api/images/downloadFile/boxingWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Sport'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'canoeing.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'canoeing.m4a'
PRINT @idimage
exec dbo.addWord 'canoeing','https://192.168.1.24/api/images/downloadFile/canoeingWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

/*INSERT INTO dbo.ntfs_image (name,is_directory,is_archive) VALUES ('Sport', 1, 0);
GO
*/
/*
INSERT INTO dbo.ntfs_image
([name],[file_stream])
SELECT 'aerobics.jpg',* FROM OPENROWSET(BULK N'D:\Studia\Praca inzynierska\Grafika do sl�w\Sport\aerobics.jpg', SINGLE_BLOB) AS FileData
GO

--SELECT  * FROM  dbo.ntfs_image WHERE name = 'aerobics.jpg'
*/
/*INSERT INTO dbo.ntfs_audio(name,is_directory,is_archive) VALUES ('Sport', 1, 0);
GO
*/
------------------------------
-- Kategoria Zwierz�ta
---------------------------------
------------------------------------------
--Dodanie kluczy do zdj�� o zwierz�tach
----------------------------------------
DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'dog.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/dog.jpg',0,0
GO 

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'cat.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/cat.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'rabbit.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/rabbit.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'hamster.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/hamster.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'goldfish.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/goldfish.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'pigeon.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/pigeon.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'cow.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/cow.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'horse.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/horse.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'chicken.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/chicken.jpg',0,0
GO

DECLARE @idimageFiletable uniqueidentifier
SELECT @idimageFiletable =  stream_id FROM  dbo.ntfs_image WHERE name = 'pig.jpg'
exec dbo.addImage @idimageFiletable,'https://192.168.1.24/api/images/downloadFile/pig.jpg',0,0
GO

-----------------------------------------
-- Kategoria Zwierz�ta
-----------------------------------------
-----------------------------------------------
--Dodanie kluczy do plik�w audio o zwierzetach
-------------------------------------------------
DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'dog.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/dog.m4a',0,0
GO 

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'cat.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/cat.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'rabbit.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/rabbit.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'hamster.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/hamster.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'goldfish.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/goldfish.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'pigeon.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/pigeon.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'cow.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/cow.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'horse.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/horse.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'chicken.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/chicken.m4a',0,0
GO

DECLARE @idAudioFiletable uniqueidentifier
SELECT @idAudioFiletable =  stream_id FROM  dbo.ntfs_audio WHERE name = 'pig.m4a'
exec dbo.addAudio @idAudioFiletable,'https://192.168.1.24/api/audio/downloadFile/pig.m4a',0,0
GO
----------------------------------
DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Zwierz�ta'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'dog.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'dog.m4a'
PRINT @idimage
exec dbo.addWord 'dog','https://192.168.1.24/api/images/downloadFile/dogWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Zwierz�ta'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'cat.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'cat.m4a'
PRINT @idimage
exec dbo.addWord 'cat','https://192.168.1.24/api/images/downloadFile/catWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Zwierz�ta'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'rabbit.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'rabbit.m4a'
PRINT @idimage
exec dbo.addWord 'rabbit','https://192.168.1.24/api/images/downloadFile/rabbitWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Zwierz�ta'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'hamster.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'hamster.m4a'
PRINT @idimage
exec dbo.addWord 'hamster','https://192.168.1.24/api/images/downloadFile/hamsterWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Zwierz�ta'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'goldfish.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'goldfish.m4a'
PRINT @idimage
exec dbo.addWord 'goldfish','https://192.168.1.24/api/images/downloadFile/goldfishWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Zwierz�ta'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'pigeon.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'pigeon.m4a'
PRINT @idimage
exec dbo.addWord 'pigeon','https://192.168.1.24/api/images/downloadFile/pigeonWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Zwierz�ta'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'cow.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'cow.m4a'
PRINT @idimage
exec dbo.addWord 'cow','https://192.168.1.24/api/images/downloadFile/cowWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Zwierz�ta'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'horse.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'horse.m4a'
PRINT @idimage
exec dbo.addWord 'horse','https://192.168.1.24/api/images/downloadFile/horseWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Zwierz�ta'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'chicken.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'chicken.m4a'
PRINT @idimage
exec dbo.addWord 'chicken','https://192.168.1.24/api/images/downloadFile/chickenWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO

DECLARE @idLang INT 
SELECT @idLang = language_id_pk FROM language WHERE language_name = 'Angielski'
PRINT @idLang

DECLARE @idCat INT 
SELECT @idCat = category_id_pk FROM category WHERE category_name = 'Zwierz�ta'
PRINT @idCat

DECLARE @idimage int
DECLARE @idAudio int
SELECT @idimage = image.image_id_pk FROM  dbo.image INNER JOIN dbo.ntfs_image ON image.ntfs_image_id_fk = dbo.ntfs_image.stream_id WHERE name = 'pig.jpg'
SELECT @idAudio = audio.audio_id_pk FROM  dbo.audio INNER JOIN dbo.ntfs_audio ON audio.ntfs_audio_id_fk = dbo.ntfs_audio.stream_id WHERE name = 'pig.m4a'
PRINT @idimage
exec dbo.addWord 'pig','https://192.168.1.24/api/images/downloadFile/pigWord.jpg',@idCat,@idLang,@idimage,@idAudio,0,0
GO
/*
INSERT INTO dbo.ntfs_image (name,is_directory,is_archive) VALUES ('Zwierz�ta', 1, 0);
GO
*/
/*
INSERT INTO dbo.ntfs_audio(name,is_directory,is_archive) VALUES ('Zwierz�ta', 1, 0);
GO
*/


/*
DECLARE @idWordFK INT
SELECT @idWordFK = word_id_pk FROM word WHERE word_name = 'canoeing'
*/
-- Zapytania do gier-
----------------------------------------
/*
SELECT * FROM word 
INNER JOIN category ON  word.category_id_fk = category.category_id_pk
INNER JOIN image ON image.word_id_fk = word.word_id_pk
LEFT JOIN audio ON audio.word_id_fk = word.word_id_pk
WHERE category.category_name = 'Sport'
ORDER BY word.word_id_pk
OFFSET 0 ROWS
FETCH NEXT 4 ROWS ONLY
GO
*/

/*
DECLARE @img AS VARBINARY(MAX)
DECLARE @path hierarchyid

SELECT @path =  path_locator FROM  dbo.ntfs_image WHERE name = 'Sport'

SELECT @img = CAST(BulkColumn AS VARBINARY(MAX)) 
FROM OPENROWSET(BULK 'D:\Studia\Praca inzynierska\Grafika do sl�w\Sport\aerobics.jpg', SINGLE_BLOB ) AS x
INSERT INTO dbo.ntfs_image(name, file_stream)
SELECT 'aerobics.jpg', @img

UPDATE dbo.ntfs_image
SET parent_path_locator= @path
WHERE name='aerobics.jpg'
 
SELECT * FROM dbo.ntfs_image
*/

------------------------
-- Dodanie gier
-----------------------
exec dbo.addGame 'Find Out Picture',0,0
exec dbo.addGame 'Find Out Vocabulary',0,0
exec dbo.addGame 'Drag And Drop',0,0
exec dbo.addGame 'Memory Game',0,0
exec dbo.addGame 'Select And Adjust',0,0
------------------------
-- Dodanie Nauczyciela
-----------------------
--haslo do nauczyciela testowego: teacherTest1
exec dbo.addAccount 'teacherTest','$2a$10$r1s1zG46DRdZJjny/HBR7OHG64xIywSW5J6AZpN.FUpVsTipxuLM2','teacherTest@wp.pl',2
GO
exec dbo.addTeacher 'Tomasz','Kowalski','Informatyk',1990,'Pozna�',1,2
GO

exec dbo.addCategoryToTeacher 1,1,0,1
exec dbo.addCategoryToTeacher 2,1,0,1
/*
SELECT * FROM child INNER JOIN account ON child.account_id_fk = account_id_pk WHERE account_name = 'admin'
GO
SELECT * FROM teacher INNER JOIN account ON teacher.account_id_fk = account_id_pk WHERE account_name = 'admin'
GO
*/




