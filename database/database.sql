CREATE SEQUENCE User_Profile_Id_Seq START WITH 1 INCREMENT BY 1
go
CREATE TABLE User_Profiles (User_id NUMBER(19) NOT NULL, Avatar_URL VARCHAR(255), Email VARCHAR(255) not null, First_Name VARCHAR(255) not null, Last_Name VARCHAR(255) not null, Phone_Number bigint, Salutation VARCHAR(255), Job_Title VARCHAR(255), PRIMARY KEY (User_id))
go
create table projects (Project_id bigint not null, creation_date timestamp, description_html CLOB, description_short CLOB, likes integer, name varchar(255), rating double, rating_count integer, status varchar(255), primary key (Project_id))

go
CREATE TABLE Project_Comments (Comment_id NUMBER(19) NOT NULL, COMMENT_DESCRIPTION VARCHAR(5000), CREATION_DATE DATETIME,
User_id NUMBER(19),Project_id NUMBER(19), PRIMARY KEY (Comment_id,User_id,Project_id))
go
create sequence project_id_seq start with 1 increment by 1
go
create sequence comment_id_seq start with 1 increment by 1
go
CREATE TABLE Project_Members (MEMBER_ID NUMBER(19) NOT NULL, PROJECT_ID NUMBER(19) NOT NULL,USER_ID  NUMBER(19) NOT NULL, PRIMARY KEY(PROJECT_ID,USER_ID))
go
create sequence MEMBER_ID_SEQ start with 1 increment by 1
go
ALTER TABLE Project_Members ADD FOREIGN KEY (USER_ID) REFERENCES User_Profiles(USER_ID)
go
ALTER TABLE USER_PROFILES ADD COLUMN ENABLED BOOLEAN DEFAULT FALSE
go
Alter Table USER_PROFILES Add COLUMN VERIFICATION_TOKEN VARCHAR2(5000)
go
Alter Table USER_PROFILES Add COLUMN PASSWORD VARCHAR2(5000)
go
CREATE  TABLE Project_Prototypes (Prototype_Id NUMBER(19) NOT NULL, Title VARCHAR2(2000), Created_Date DateTime, Description CLOB, URL VARCHAR2(2000), Project_ID NUMBER(19),  PRIMARY KEY (Prototype_id,Project_id))
go
Alter Table Project_Prototypes  Add Foreign key (Project_ID) References Projects (Project_ID)
go
Alter Table Project_Members Add Foreign key (Project_ID) References Projects (Project_ID)
go
create sequence PROTOTYPE_ID_SEQ start with 1 increment by 1
go
Alter Table Projects Add Column PROJECT_OWNER NUMBER(19)
go
Alter Table Projects  Add Foreign key (PROJECT_OWNER) References User_Profiles (User_id)
go
Alter Table Project_Comments  Add Foreign key (Project_ID) References Projects (Project_ID)
go
ALTER TABLE PROJECTS  ALTER COLUMN DESCRIPTION_SHORT RENAME TO PROJECT_TITLE
go
CREATE UNIQUE INDEX SHOWROOMAPP.USER_PROFILES_EMAIL_uindex ON USER_PROFILES(EMAIL);
go
create table PROJECT_UPDATES (ID NUMBER(19) not null  primary key,   CREATION_DATE TIMESTAMP(6),  DESCRIPTION   CLOB,  PROJECT_ID    NUMBER(19) not null
    constraint FK53EXXPLM5OTNQ44NL7053Y7B5
    references PROJECTS
)