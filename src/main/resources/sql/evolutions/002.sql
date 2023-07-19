--liquibase formatted sql
--changeset adam.zimny:2 labels:DEV

-----------------------------------------------------
--------------Define primary keys-------------------
-----------------------------------------------------
ALTER TABLE dbo.teacher
ADD CONSTRAINT teacher_pk
PRIMARY KEY (id);
GO

ALTER TABLE dbo.child
ADD CONSTRAINT child_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.account
ADD CONSTRAINT account_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.language
ADD CONSTRAINT language_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.category
ADD CONSTRAINT category_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.category_teacher
ADD CONSTRAINT category_teacher_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.word
ADD CONSTRAINT word_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.statistic
ADD CONSTRAINT statistic_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.game
ADD CONSTRAINT game_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.image
ADD CONSTRAINT image_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.audio
ADD CONSTRAINT audio_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.statistic_result
ADD CONSTRAINT statistic_result_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.gameplay
ADD CONSTRAINT gameplay_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.gameplay_result
ADD CONSTRAINT gameplay_result_pk
PRIMARY KEY (id)
GO

ALTER TABLE dbo.role
ADD CONSTRAINT role_pk
PRIMARY KEY (id)
GO
-------------------------------------
-----Define foreign keys-------------
-------------------------------------

ALTER TABLE dbo.teacher
ADD CONSTRAINT teacher_language_fk
 FOREIGN KEY (language_id_fk)
REFERENCES dbo.language(id);
GO

ALTER TABLE dbo.teacher
ADD CONSTRAINT teacher_account_fk
FOREIGN KEY (account_id_fk)
REFERENCES dbo.account(id);
GO

ALTER TABLE dbo.child
ADD CONSTRAINT child_account_fk
FOREIGN KEY (account_id_fk)
REFERENCES dbo.account(id);
GO

ALTER TABLE dbo.word
ADD CONSTRAINT word_category_fk
FOREIGN KEY (category_id_fk)
REFERENCES dbo.category(id);
GO


ALTER TABLE dbo.gameplay
ADD CONSTRAINT gameplay_language_fk
FOREIGN KEY (language_id_fk)
REFERENCES dbo.language(id);
GO

ALTER TABLE dbo.gameplay
ADD CONSTRAINT gameplay_game_fk
FOREIGN KEY (game_id_fk)
REFERENCES dbo.game(id);
GO

ALTER TABLE dbo.gameplay
ADD CONSTRAINT gameplay_category_fk
FOREIGN KEY (category_id_fk)
REFERENCES dbo.category(id);
GO

ALTER TABLE dbo.gameplay_result
ADD CONSTRAINT gameplay_result_game_match_fk
FOREIGN KEY (gameplay_id_fk)
REFERENCES dbo.gameplay(id);
GO

ALTER TABLE dbo.gameplay_result
ADD CONSTRAINT gameplay_result_statistic_result_fk
FOREIGN KEY (statistic_result_id_fk)
REFERENCES dbo.statistic_result(id);
GO

ALTER TABLE dbo.statistic_result
ADD CONSTRAINT statistic_result_statistic_fk
FOREIGN KEY (statistic_id_fk)
REFERENCES dbo.statistic(id);
GO

ALTER TABLE dbo.category
ADD CONSTRAINT category_language_fk
FOREIGN KEY (language_id_fk)
REFERENCES dbo.language(id);
GO

ALTER TABLE dbo.word
ADD CONSTRAINT word_language_fk
FOREIGN KEY (language_id_fk)
REFERENCES dbo.language(id);
GO

ALTER TABLE dbo.word
ADD CONSTRAINT word_image_fk
FOREIGN KEY (image_id_fk)
REFERENCES dbo.image(id);
GO

ALTER TABLE dbo.word
ADD CONSTRAINT word_audio_fk
FOREIGN KEY (audio_id_fk)
REFERENCES dbo.audio(id);
GO

ALTER TABLE dbo.account
ADD CONSTRAINT account_role_fk
FOREIGN KEY (role_id_fk)
REFERENCES dbo.role(id);
GO


ALTER TABLE dbo.category_teacher
ADD CONSTRAINT category_teacher_category_fk
FOREIGN KEY (category_id_fk)
REFERENCES dbo.category(id);
GO

ALTER TABLE dbo.category_teacher
ADD CONSTRAINT category_teacher_teacher_fk
FOREIGN KEY (teacher_id_fk)
REFERENCES dbo.teacher(id);
GO

--rollback  DROP CONSTRAINT role_pk;
--rollback  DROP CONSTRAINT gameplay_result_pk;
--rollback  DROP CONSTRAINT gameplay_pk;
--rollback  DROP CONSTRAINT statistic_result_pk;
--rollback  DROP CONSTRAINT audio_pk;
--rollback  DROP CONSTRAINT image_pk;
--rollback  DROP CONSTRAINT game_pk;
--rollback  DROP CONSTRAINT statistic_pk;
--rollback  DROP CONSTRAINT word_pk;
--rollback  DROP CONSTRAINT category_teacher_pk;
--rollback  DROP CONSTRAINT category_pk;
--rollback  DROP CONSTRAINT language_pk;
--rollback  DROP CONSTRAINT account_pk;
--rollback  DROP CONSTRAINT child_pk;
--rollback  DROP CONSTRAINT teacher_pk;

--rollback  DROP CONSTRAINT category_teacher_teacher_fk;
--rollback  DROP CONSTRAINT category_teacher_category_fk;
--rollback  DROP CONSTRAINT account_role_fk;
--rollback  DROP CONSTRAINT word_audio_fk;
--rollback  DROP CONSTRAINT word_image_fk;
--rollback  DROP CONSTRAINT word_language_fk;
--rollback  DROP CONSTRAINT category_language_fk;
--rollback  DROP CONSTRAINT gameplay_result_statistic_result_fk;
--rollback  DROP CONSTRAINT gameplay_result_game_match_fk;
--rollback  DROP CONSTRAINT gameplay_category_fk;
--rollback  DROP CONSTRAINT gameplay_game_fk;
--rollback  DROP CONSTRAINT gameplay_language_fk;
--rollback  DROP CONSTRAINT word_category_fk;
--rollback  DROP CONSTRAINT child_account_fk;
--rollback  DROP CONSTRAINT teacher_account_fk;
--rollback  DROP CONSTRAINT teacher_language_fk;

