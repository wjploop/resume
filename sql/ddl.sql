CREATE TABLE avatar
(
  id  INT AUTO_INCREMENT
    PRIMARY KEY,
  img BLOB NULL
)
  ENGINE = InnoDB;

CREATE TABLE education
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  resume_Id   INT          NULL,
  time_period VARCHAR(255) NULL,
  school_name VARCHAR(255) NULL,
  major       VARCHAR(255) NULL,
  description TEXT         NULL
)
  ENGINE = InnoDB;

CREATE INDEX education_resume__fk
  ON education (resume_Id);

CREATE TABLE experience
(
  id           INT AUTO_INCREMENT
    PRIMARY KEY,
  resume_id    INT          NULL,
  time_period  VARCHAR(255) NULL,
  organization VARCHAR(255) NULL,
  job_title    VARCHAR(255) NULL,
  description  TEXT         NULL
)
  ENGINE = InnoDB;

CREATE INDEX experience_resume__fk
  ON experience (resume_id);

CREATE TABLE preference
(
  id           INT AUTO_INCREMENT
    PRIMARY KEY,
  job_function VARCHAR(100) NOT NULL,
  job_type     VARCHAR(100) NULL,
  job_city     VARCHAR(100) NULL,
  salary       VARCHAR(10)  NULL,
  duty_time    VARCHAR(100) NULL
)
  ENGINE = InnoDB;

CREATE TABLE resume
(
  id         INT AUTO_INCREMENT
    PRIMARY KEY,
  name       VARCHAR(255) NULL,
  user       INT          NULL,
  avatar     INT          NULL,
  preference INT          NULL,
  CONSTRAINT resume_avatar__fk
  FOREIGN KEY (avatar) REFERENCES avatar (id),
  CONSTRAINT resume_preference__fk
  FOREIGN KEY (preference) REFERENCES preference (id)
)
  ENGINE = InnoDB;

CREATE INDEX resume_user__fk
  ON resume (user);

CREATE INDEX resume_avator__fk
  ON resume (avatar);

CREATE INDEX resume_preference__fk
  ON resume (preference);

ALTER TABLE education
  ADD CONSTRAINT education_resume__fk
FOREIGN KEY (resume_Id) REFERENCES resume (id);

ALTER TABLE experience
  ADD CONSTRAINT experience_resume__fk
FOREIGN KEY (resume_id) REFERENCES resume (id);

CREATE TABLE skill
(
  id           INT AUTO_INCREMENT
    PRIMARY KEY,
  resume_id    INT          NULL,
  name         VARCHAR(255) NOT NULL,
  level_number INT          NULL,
  level_name   VARCHAR(100) NULL,
  CONSTRAINT skill_resume__fk
  FOREIGN KEY (resume_id) REFERENCES resume (id)
)
  ENGINE = InnoDB;

CREATE INDEX skill_resume__fk
  ON skill (resume_id);

CREATE TABLE user
(
  id     INT AUTO_INCREMENT
    PRIMARY KEY,
  name   VARCHAR(255) NOT NULL,
  sex    VARCHAR(100) NOT NULL,
  age    VARCHAR(10)  NOT NULL,
  phone  VARCHAR(100) NULL,
  email  VARCHAR(100) NULL,
  adress VARCHAR(100) NULL,
  motto  VARCHAR(255) NULL
)
  COMMENT '用户表'
  ENGINE = InnoDB;

ALTER TABLE resume
  ADD CONSTRAINT resume_user__fk
FOREIGN KEY (user) REFERENCES user (id);

