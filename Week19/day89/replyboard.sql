create database replyBoard;
use replyBoard;
drop table if exists board;
create table board(
no INT PRIMARY KEY auto_increment,
WRITER CHAR(40) NOT NULL,
TITLE CHAR(100) NOT NULL,
CONTENT TEXT(1000) NOT NULL,
PASSWORD CHAR(30) NOT NULL,
createdDate TimeStamp default now() Not null,
GROUPNUM TINYINT NOT NULL,
STEPNUM TINYINT DEFAULT 0 NOT NULL,
indentNum TINYINT NOT NULL DEFAULT 0
); 

select * from board;