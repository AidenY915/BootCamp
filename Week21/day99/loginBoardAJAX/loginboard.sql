create database loginboard;
use loginboard;

drop table if exists board;
drop table if exists member;

create table member(
name VARCHAR(20),
id CHAR(20) PRIMARY KEY,
nickname VARCHAR(20),
password CHAR(20) NOT NULL,
email VARCHAR(50),
postNum VARCHAR(10),
detailAddress VARCHAR(100),
birthday CHAR(8),
phone CHAR(12),
sex TINYINT
);

select * from member;

CREATE TABLE board(
no INT PRIMARY KEY AUTO_INCREMENT,
id CHAR(20),
title VARCHAR(100),
content TEXT(1000),
createdDate datetime default now(),
views INT DEFAULT 0,
groupNum INT DEFAULT 0,
stepNum INT DEFAULT 0,
indentNum INT DEFAULT 0,
FOREIGN KEY (id) REFERENCES member(id) ON UPDATE CASCADE
);

select * from board;