create database uportaldb;
use uportaldb;

drop user java@localhost;
create user java@localhost identified by 'eclipseisabitch';
grant all privileges on uportaldb to java@localhost;

create table users(
	userid int not null auto_increment,
	firstname varchar(50) not null,
	lastname varchar(50) not null,
	email varchar(100) not null,
	username varchar(100) not null,
	password varchar(100) not null,
	enabled tinyint(1) default true,
	collegeid int default null,
	departmentid int default null,
	courseid int default null,
	primary key(userid)	
)ENGINE = InnoDB;

create table userTypes(
	typeid int not null auto_increment,
	typename varchar(15) not null,
	primary key(typeid)
)ENGINE = InnoDB;

create table roles(
	roleid int not null auto_increment,
	rolename varchar(20) not null,
	primary key(roleid)
)ENGINE = InnoDB;

create table rolesPerType(
	roleid int not null,
	typeid int not null,
	constraint fk_typeid foreign key (typeid)
	references userTypes(typeid),
	constraint fk_roleid foreign key (roleid)
	references roles(roleid)
)ENGINE = InnoDB;

create table userRoles(
	userid int not null,
	typeid int not null,
	constraint fk_ur_userid foreign key (userid)
	references users(userid),
	constraint fk_ur_typeid foreign key (typeid)
	references userTypes(typeid)
)ENGINE = InnoDB;

grant all privileges on uportaldb.users to 'java'@'localhost' with grant option;
grant all privileges on uportaldb.userTypes to 'java'@'localhost' with grant option;
grant all privileges on uportaldb.roles to 'java'@'localhost' with grant option;
grant all privileges on uportaldb.userRoles to 'java'@'localhost' with grant option;
grant all privileges on uportaldb.rolesPerType to 'java'@'localhost' with grant option;

insert into userTypes (typename) value ('GENERAL');
insert into userTypes (typename) value ('STUDENT');
insert into userTypes (typename) value ('FACULTY');
insert into userTypes (typename) value ('ADMIN_PORTAL');
insert into userTypes (typename) value ('ADMIN_MAPS');
insert into userTypes (typename) value ('ADMIN_BUDDY');
insert into userTypes (typename) value ('ADMIN_CLASS');
insert into userTypes (typename) value ('ADMIN_GYM');
insert into userTypes (typename) value ('GOD');

insert into roles (rolename) value ('ROLE_GENERAL');
insert into roles (rolename) value ('ROLE_STUDENT');
insert into roles (rolename) value ('ROLE_FACULTY');
insert into roles (rolename) value ('ROLE_ADMIN');
insert into roles (rolename) value ('ROLE_ADMIN_PORTAL');
insert into roles (rolename) value ('ROLE_ADMIN_MAPS');
insert into roles (rolename) value ('ROLE_ADMIN_BUDDY');
insert into roles (rolename) value ('ROLE_ADMIN_CLASS');
insert into roles (rolename) value ('ROLE_ADMIN_GYM');
insert into roles (rolename) value ('ROLE_GOD');

insert into rolesPerType (typeid, roleid) value (1, 1);
insert into rolesPerType (typeid, roleid) value (2, 1);
insert into rolesPerType (typeid, roleid) value (2, 2);
insert into rolesPerType (typeid, roleid) value (3, 1);
insert into rolesPerType (typeid, roleid) value (3, 3);
insert into rolesPerType (typeid, roleid) value (4, 1);
insert into rolesPerType (typeid, roleid) value (4, 4);
insert into rolesPerType (typeid, roleid) value (4, 5);
insert into rolesPerType (typeid, roleid) value (5, 1);
insert into rolesPerType (typeid, roleid) value (5, 4);
insert into rolesPerType (typeid, roleid) value (5, 6);
insert into rolesPerType (typeid, roleid) value (6, 1);
insert into rolesPerType (typeid, roleid) value (6, 4);
insert into rolesPerType (typeid, roleid) value (6, 7);
insert into rolesPerType (typeid, roleid) value (7, 1);
insert into rolesPerType (typeid, roleid) value (7, 4);
insert into rolesPerType (typeid, roleid) value (7, 8);
insert into rolesPerType (typeid, roleid) value (8, 1);
insert into rolesPerType (typeid, roleid) value (8, 4);
insert into rolesPerType (typeid, roleid) value (8, 9);
insert into rolesPerType (typeid, roleid) value (9, 1);
insert into rolesPerType (typeid, roleid) value (9, 4);
insert into rolesPerType (typeid, roleid) value (9, 5);
insert into rolesPerType (typeid, roleid) value (9, 6);
insert into rolesPerType (typeid, roleid) value (9, 7);
insert into rolesPerType (typeid, roleid) value (9, 8);
insert into rolesPerType (typeid, roleid) value (9, 9);
insert into rolesPerType (typeid, roleid) value (9, 10);

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

