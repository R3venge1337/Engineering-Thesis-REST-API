--liquibase formatted sql
--changeset adam.zimny:3 labels:DEV
------------------------------------------------------------------------------
-- CHECK
------------------------------------------------------------------------------

ALTER TABLE dbo.account
ADD CONSTRAINT CK_account_email
CHECK (email LIKE '%_@_%_.__%');
GO

ALTER TABLE dbo.role
ADD CONSTRAINT CK_role_name
CHECK (name LIKE 'ROLE_%');
GO

--rollback  DROP CONSTRAINT CK_role_name;
--rollback  DROP CONSTRAINT CK_account_email;