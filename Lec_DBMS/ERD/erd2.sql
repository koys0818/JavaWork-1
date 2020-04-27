
/* Drop Tables */

DROP TABLE regist CASCADE CONSTRAINTS;
DROP TABLE class CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE class
(
	classno number NOT NULL,
	name varchar2(10) NOT NULL,
	grade number,
	particip number,
	address clob,
	cl_year date,
	profno number NOT NULL,
	PRIMARY KEY (classno)
);


CREATE TABLE department
(
	deptno number NOT NULL,
	name varchar2(10) NOT NULL,
	address clob,
	tel varchar2(15),
	PRIMARY KEY (deptno)
);


CREATE TABLE professor
(
	profno number NOT NULL,
	name varchar2(10) NOT NULL,
	jumin varchar2(13) NOT NULL,
	pos varchar2(6),
	hiredate date NOT NULL,
	tel varchar2(15),
	address clob,
	deptno number NOT NULL,
	PRIMARY KEY (profno)
);


CREATE TABLE regist
(
	studno number NOT NULL,
	classno number NOT NULL
);


CREATE TABLE student
(
	studno number NOT NULL,
	name varchar2(10) NOT NULL,
	jumin varchar2(13) NOT NULL,
	grade number NOT NULL,
	tel varchar2(12),
	address clob,
	deptno number NOT NULL,
	PRIMARY KEY (studno)
);



/* Create Foreign Keys */

ALTER TABLE regist
	ADD FOREIGN KEY (classno)
	REFERENCES class (classno)
;


ALTER TABLE professor
	ADD FOREIGN KEY (deptno)
	REFERENCES department (deptno)
;


ALTER TABLE student
	ADD FOREIGN KEY (deptno)
	REFERENCES department (deptno)
;


ALTER TABLE class
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE regist
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
;



