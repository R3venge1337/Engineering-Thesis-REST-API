--liquibase formatted sql
--changeset adam.zimny:1 labels:DEV

--------------------------------------------
---------------Tables-----------------------
--------------------------------------------

--------------------------------------------
---------------Teacher----------------------
--------------------------------------------
CREATE TABLE dbo.teacher (
    id int NOT NULL IDENTITY(1,1),
    first_name  varchar(60) NOT NULL,
	surname varchar(60) NOT NULL,
    profession varchar(100) NOT NULL,
    year_of_birth smallint NOT NULL,
	city varchar(70) NOT NULL,
	language_id_fk int NOT NULL,
	account_id_fk int NOT NULL
);
GO
---------------------------
-------Child-------------
---------------------------
CREATE TABLE dbo.child (
    id int NOT NULL IDENTITY(1,1),
    first_name  varchar(50) NOT NULL,
	surname varchar(50) NOT NULL,
    year_of_birth smallint NOT NULL,
	city varchar(50) NOT NULL,
	quest_uuid varchar(100) NULL,
	account_id_fk int NOT NULL
);
GO

---------------------------
-------Account---------------
---------------------------
CREATE TABLE dbo.account (
    id int NOT NULL IDENTITY(1,1),
    nickname varchar(100) NOT NULL,
	password varchar(255) NOT NULL,
	date_created datetime NOT NULL,
	email varchar(320) NOT NULL,
	is_active bit NOT NULL,
	role_id_fk int NOT NULL,
);
GO

---------------------------
-------Language---------------
---------------------------
CREATE TABLE dbo.language (
    id int NOT NULL IDENTITY(1,1),
    name varchar(60) NOT NULL,
	date_created datetime NOT NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL
);
GO

-------------------------------
-------Category---------------
-------------------------------
CREATE TABLE dbo.category (
    id int NOT NULL IDENTITY(1,1),
    name  varchar(60) NOT NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL,
	language_id_fk int NOT NULL
);
GO

-------------------------------
-------Teacher categories---
-------------------------------
CREATE TABLE dbo.category_teacher (
    id int NOT NULL IDENTITY(1,1),
	is_new bit NOT NULL,
	is_accepted bit NOT NULL,
	category_id_fk int NOT NULL,
    teacher_id_fk int NOT NULL
);
GO

-----------------------------
-------Word-----------------
-----------------------------
CREATE TABLE dbo.word (
    id int NOT NULL IDENTITY(1,1),
    name  varchar(50) NOT NULL,
	download_uri varchar(100) NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL,
	category_id_fk  int NOT NULL,
    language_id_fk int NOT NULL,
    image_id_fk  int NULL,
    audio_id_fk int NULL
);
GO


--------------------------------
-------Statistics---------------
--------------------------------
CREATE TABLE dbo.statistic (
    id int NOT NULL IDENTITY(1,1),
    name varchar(50) NOT NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL
);
GO

----------------------------
-------Statistics -Results--
----------------------------
CREATE TABLE dbo.statistic_result (
    id int NOT NULL IDENTITY(1,1),
    result_score varchar(20) NOT NULL,
	statistic_id_fk int NOT NULL
);
GO

---------------------------
-----------Game-------------
---------------------------
CREATE TABLE dbo.game (
    id int NOT NULL IDENTITY(1,1),
    name varchar(50) NOT NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL
);
GO
---------------------------
-------Images-------------
---------------------------
CREATE TABLE dbo.image
(
    id int NOT NULL IDENTITY(1,1),
	download_uri varchar(100) NOT NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL,
)
GO


---------------------------
-------Audio---------
---------------------------
CREATE TABLE dbo.audio
(
    id int NOT NULL IDENTITY(1,1),
	download_uri varchar(100) NOT NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL,
)
GO
---------------------------
-------Gameplay-----------
---------------------------
CREATE TABLE dbo.gameplay (
    id int NOT NULL IDENTITY(1,1),
	starting_date datetime NOT NULL,
	ending_date datetime NOT NULL,
	language_id_fk int NOT NULL,
	game_id_fk int NOT NULL,
	category_id_fk int NOT NULL,
	quest_uuid_fk varchar(100) NULL
);
GO

---------------------------
-----Gameplay Results------
---------------------------

CREATE TABLE dbo.gameplay_result (
    id int NOT NULL IDENTITY(1,1),
	gameplay_id_fk int NOT NULL,
	statistic_result_id_fk int NOT NULL
);
GO

---------------------------
-------ROLE----------------
---------------------------
CREATE TABLE dbo.role (
    id int NOT NULL IDENTITY(1,1),
    name varchar(50) NOT NULL,
	date_created datetime NOT NULL
);
GO

--rollback DROP TABLE dbo.role;
--rollback DROP TABLE dbo.gameplay_result;
--rollback DROP TABLE dbo.gameplay;
--rollback DROP TABLE dbo.audio;
--rollback DROP TABLE dbo.image;
--rollback DROP TABLE dbo.game;
--rollback DROP TABLE dbo.statistic_result;
--rollback DROP TABLE dbo.statistic;
--rollback DROP TABLE dbo.word;
--rollback DROP TABLE dbo.category_teacher;
--rollback DROP TABLE dbo.category;
--rollback DROP TABLE dbo.language;
--rollback DROP TABLE dbo.account;
--rollback DROP TABLE dbo.child;
--rollback DROP TABLE dbo.teacher;