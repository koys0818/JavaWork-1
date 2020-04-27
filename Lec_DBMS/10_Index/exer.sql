	
다음과 같은 구조의 테이블들 이 있을때 다음의 문제들을 해결하는 SQL 문을 작성하세요

<T_STUDENT  : 학생 테이블>

학번

STUDNO (PK)

이름

NAME (NN)

아이디

ID (NN)

학년

GRADE

학과번호

DEPTNO (FK)

담담교수번호

PROFNO (FK)

 

<T_PROFESSOR : 교수님 테이블>

교수번호

PROFNO (PK)

이름

NAME (NN)

아이디

ID (NN)

급여

PAY (NN)

학과번호

DEPTNO (FK)

 

<T_DEPARTMENT : 학과 테이블>

학과번호

PROFNO (PK)

학과명

DNAME (NN)

 

 

T_STUDENT.PROFNO  → T_PROFESSOR.PROFNO 참조

T_STUDENT.DEPTNO  → T_DEPARTMENT.DEPTNO 참조

T_PROFESSOR.DEPTNO  → T_DEPARTMENT.DEPTNO 참조

INSERT INTO T_STUDENT VALUES  (9091, '김수진', 'sooplus', 2, 101, 1004);

DELETE FROM T_STUDENT WHERE grade = 4;
SELECT * FROM T_STUDENT ;

SELECT NAME , PAY FROM T_PROFESSOR WHERE pay >= 5000; 

SELECT p.NAME "교수님 이름" , d.DNAME "소속 학과명"  FROM T_PROFESSOR p, T_DEPARTMENT d WHERE p.DEPTNO = d.DEPTNO ;

SELECT DEPTNO1 FROM T_STUDENT WHERE name = '허우';

SELECT * FROM T_STUDENT ;

SELECT NAME "학생이름" , DEPTNO1 "학과명"
FROM T_STUDENT 
WHERE DEPTNO1 = (SELECT DEPTNO1 FROM T_STUDENT WHERE name = '노정호')
;

CREATE OR REPLACE VIEW v_stud_info(sname, dname, pname)
AS 
SELECT s.NAME "학생이름" , d.DNAME "학생학과명" , p.NAME "담당교수님 이름"
FROM T_STUDENT s, T_DEPARTMENT d, T_PROFESSOR p
WHERE s.DEPTNO1 = d.DEPTNO AND d.DEPTNO = p.DEPTNO AND s.PROFNO = p.PROFNO 
;

SELECT * FROM v_stud_info;

SELECT * FROM T_STUDENT ;

SELECT s.NAME "학생이름" , d.DNAME "학생학과명" , p.NAME "담당교수님 이름"
FROM T_STUDENT s, T_DEPARTMENT d, T_PROFESSOR p
WHERE s.DEPTNO1 = d.DEPTNO AND d.DEPTNO = p.DEPTNO AND s.PROFNO = p.PROFNO 
;

ALTER TABLE T_STUDENT ADD (BIRTHDAY2  DATE);
SELECT * FROM T_STUDENT ;

SELECT tname FROM tab;

COMMIT;

SELECT * FROM T_DEPT2 ;

CREATE TABLE T_MEMBER2 (
			mb_uid NUMBER PRIMARY KEY ,
			mb_name varchar2(20) NOT NULL,
			mb_jumin char(13) UNIQUE ,
			mb_age number CHECK (mb_age > 0),
			mb_dept varchar2(4) REFERENCES t_dept2(dcode)
);

CREATE OR REPLACE VIEW v_stud_info2(sname, dname, pname)
AS 
SELECT s.NAME "학생이름" , d.DNAME "학생학과명" , p.NAME "담당교수님 이름"
FROM T_STUDENT s, T_DEPARTMENT d, T_PROFESSOR p
WHERE s.DEPTNO1 = d.DEPTNO AND s.PROFNO = p.PROFNO ;

SELECT * FROM v_stud_info2;