--liquibase formatted sql
--changeset adam.zimny:1 labels:DEV

--------------------------------------------
---------------Tables-----------------------
--------------------------------------------

--------------------------------------------
---------------Teacher----------------------
--------------------------------------------
CREATE TABLE dbo.teacher (
    id bigint NOT NULL IDENTITY(1,1),
    first_name  varchar(60) NOT NULL,
	surname varchar(60) NOT NULL,
    profession varchar(100) NOT NULL,
    year_of_birth smallint NOT NULL,
	city varchar(70) NOT NULL,
	language_id_fk bigint NOT NULL,
	account_id_fk bigint NOT NULL
);
GO
---------------------------
-------Child-------------
---------------------------
CREATE TABLE dbo.child (
    id bigint NOT NULL IDENTITY(1,1),
    first_name  varchar(50) NOT NULL,
	surname varchar(50) NOT NULL,
    year_of_birth smallint NOT NULL,
	city varchar(50) NOT NULL,
	quest_uuid varchar(100) NULL,
	account_id_fk bigint NOT NULL
);
GO

---------------------------
-------Account---------------
---------------------------
CREATE TABLE dbo.account (
    id bigint IDENTITY(1,1) NOT NULL,
    nickname varchar(100) NOT NULL,
	password varchar(255) NOT NULL,
	date_created datetime NOT NULL,
	email varchar(320) UNIQUE NOT NULL,
	is_active bit NOT NULL,
	role_id_fk bigint NOT NULL,
);
GO

---------------------------
-------Language---------------
---------------------------
CREATE TABLE dbo.language (
    id bigint NOT NULL IDENTITY(1,1),
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
    id bigint NOT NULL IDENTITY(1,1),
    name  varchar(60) NOT NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL,
	language_id_fk bigint NOT NULL
);
GO

-------------------------------
-------Teacher categories---
-------------------------------
CREATE TABLE dbo.category_teacher (
    id bigint NOT NULL IDENTITY(1,1),
	is_new bit NOT NULL,
	is_accepted bit NOT NULL,
	category_id_fk bigint NOT NULL,
    teacher_id_fk bigint NOT NULL
);
GO

-----------------------------
-------Word-----------------
-----------------------------
CREATE TABLE dbo.word (
    id bigint NOT NULL IDENTITY(1,1),
    name  varchar(50) NOT NULL,
	download_uri varchar(100) NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL,
	category_id_fk  bigint NOT NULL,
    language_id_fk bigint NOT NULL,
    image_id_fk bigint NULL,
    audio_id_fk bigint NULL
);
GO


--------------------------------
-------Statistics---------------
--------------------------------
CREATE TABLE dbo.statistic (
    id bigint NOT NULL IDENTITY(1,1),
    name varchar(50) NOT NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL
);
GO

----------------------------
-------Statistics -Results--
----------------------------
CREATE TABLE dbo.statistic_result (
    id bigint NOT NULL IDENTITY(1,1),
    result_score varchar(20) NOT NULL,
	statistic_id_fk bigint NOT NULL
);
GO

---------------------------
-----------Game-------------
---------------------------
CREATE TABLE dbo.game (
    id bigint NOT NULL IDENTITY(1,1),
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
    id bigint NOT NULL IDENTITY(1,1),
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
    id bigint NOT NULL IDENTITY(1,1),
	download_uri varchar(100) NOT NULL,
	is_new bit NOT NULL,
	is_accepted bit NOT NULL,
)
GO
---------------------------
-------Gameplay-----------
---------------------------
CREATE TABLE dbo.gameplay (
    id bigint NOT NULL IDENTITY(1,1),
	starting_date datetime NOT NULL,
	ending_date datetime NOT NULL,
	language_id_fk bigint NOT NULL,
	game_id_fk bigint NOT NULL,
	category_id_fk bigint NOT NULL,
	quest_uuid_fk varchar(100) NULL
);
GO

---------------------------
-----Gameplay Results------
---------------------------

CREATE TABLE dbo.gameplay_result (
    id bigint NOT NULL IDENTITY(1,1),
	gameplay_id_fk bigint NOT NULL,
	statistic_result_id_fk bigint NOT NULL
);
GO

---------------------------
-------ROLE----------------
---------------------------
CREATE TABLE dbo.role (
    id bigint NOT NULL IDENTITY(1,1),
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