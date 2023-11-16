CREATE DATABASE memberdb;
USE memberdb;
DROP TABLE if EXISTS swim;
DROP TABLE if EXISTS baseball;
DROP TABLE if EXISTS movie;
DROP TABLE if EXISTS music;
DROP TABLE if EXISTS member;
CREATE TABLE member(
	name CHAR(40) NOT NULL,
	id CHAR(40) PRIMARY KEY,
    pw CHAR(40) NOT NULL,
    sex TINYINT NOT NULL,
    email CHAR(45),
    phone CHAR(11)
);

CREATE TABLE swim(
	id CHAR(40),
    FOREIGN KEY (id) REFERENCES MEMBER (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE  baseball(
	id CHAR(40),
    FOREIGN KEY (id) REFERENCES MEMBER (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE movie(
	id CHAR(40),
    FOREIGN KEY (id) REFERENCES MEMBER (ID) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE music(
	id CHAR(40),
    FOREIGN KEY (id) REFERENCES MEMBER (ID) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO member VALUES('종석','aiden', "0000", '0', 'email@naver.com', '01012345678');

select * from member;
select * from swim;
select * from movie;
select * from music;
select * from baseball;