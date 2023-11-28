create table mvcboard(
	no int auto_increment primary key,
	name varchar(20) not null,
	title varchar(100) not null,
	contents text not null,
	hit int not null default 0,
	wtime timestamp not null default CURRENT_TIMESTAMP,
	groupnum int not null default 0,
	stepnum int not null default 0,
	indentnum int not null default 0
);