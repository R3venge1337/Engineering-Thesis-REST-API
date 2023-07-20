--liquibase formatted sql
--changeset adam.zimny:4 labels:DEV
------------------------------------------------------------------------------
-- Add uuid
------------------------------------------------------------------------------
ALTER TABLE dbo.teacher
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.child
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.account
ADD uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.language
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.category
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.category_teacher
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.word
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.statistic
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.statistic_result
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.game
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.gameplay
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.gameplay_result
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

ALTER TABLE dbo.role
ADD  uuid uniqueidentifier ROWGUIDCOL unique NOT NULL;

--rollback ALTER TABLE dbo.role DROP COLUMN uuid;
--rollback ALTER TABLE dbo.gameplay_result DROP COLUMN uuid;
--rollback ALTER TABLE dbo.gameplay DROP COLUMN uuid;
--rollback ALTER TABLE dbo.game DROP COLUMN uuid;
--rollback ALTER TABLE dbo.statistic_result DROP COLUMN uuid;
--rollback ALTER TABLE dbo.statistic DROP COLUMN uuid;
--rollback ALTER TABLE dbo.word DROP COLUMN uuid;
--rollback ALTER TABLE dbo.category_teacher DROP COLUMN uuid;
--rollback ALTER TABLE dbo.category DROP COLUMN uuid;
--rollback ALTER TABLE dbo.language DROP COLUMN uuid;
--rollback ALTER TABLE dbo.account DROP COLUMN uuid;
--rollback ALTER TABLE dbo.child DROP COLUMN uuid;
--rollback ALTER TABLE dbo.teacher DROP COLUMN uuid;