create table colleges(
	collegeid int not null auto_increment,
	collegename varchar(50) not null,
	primary key (collegeid)
)ENGINE = InnoDB;

insert into colleges (collegename) value ('College of Engineering');
insert into colleges (collegename) value ('College of Science');

grant all privileges on uportaldb.colleges to 'java'@'localhost' with grant option;

create table departments(
	collegeid int not null,
	deptid int not null auto_increment,
	deptname varchar(50) not null,
	primary key (deptid),
	constraint fk_collegeid foreign key (collegeid)
	references colleges(collegeid)
)ENGINE = InnoDB;

insert into departments (collegeid, deptname) value (1, 'Department of Computer Science');
insert into departments (collegeid, deptname) value (1, 'Department of Chemical Engineering');
insert into departments (collegeid, deptname) value (2, 'National Institute of Physics');
insert into departments (collegeid, deptname) value (2, 'Institute of Chemistry');

grant all privileges on uportaldb.departments to 'java'@'localhost' with grant option;

create table courses(
	deptid int not null,
	courseid int not null auto_increment,
	coursename varchar(50) not null,
	primary key (courseid),
	constraint fk_deptid foreign key (deptid)
	references departments(deptid)
)ENGINE = InnoDB;

insert into courses (deptid, coursename) value (1, 'BS Computer Science');
insert into courses (deptid, coursename) value (2, 'BS Chemical Engineering');
insert into courses (deptid, coursename) value (3, 'BS Applied Physics');
insert into courses (deptid, coursename) value (3, 'BS Physics');
insert into courses (deptid, coursename) value (4, 'BS Chemistry');

grant all privileges on uportaldb.courses to 'java'@'localhost' with grant option;

