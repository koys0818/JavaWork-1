-- INTICAP() 함수


-- #4101
SELECT INITCAP('pretty girl') 
FROM DUAL ;

--#4102
SELECT ID, INITCAP(ID ) ID
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

--LOWER() UPPER()
--#4103
SELECT NAME , ID , UPPER(id) 대문자, LOWER(id) 소문자
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

--LENGTH / LENGTHB
--#4104
SELECT NAME, ID , LENGTH (id) 글자수
FROM T_STUDENT 
WHERE LENGTH(ID) >= 9; -- 단일행함수는 WHERE 조건절에서 사용가능!

--#4105
SELECT NAME 이름, LENGTH (NAME ) 길이, lengthb(NAME ) 바이트
FROM T_STUDENT WHERE DEPTNO1 = 201;

--CONCAT()함수
--#4106
SELECT concat(name, POSITION) 교수님명단
FROM T_PROFESSOR 
WHERE DEPTNO = 101;

--SUBSTR()함수
SELECT substr('ABCDE', 2, 3) -- 'BCD' 문자열 인덱스 1부터 시작!
FROM dual;

SELECT SUBSTR('abcde', 20, 3) -- null(에러 아님)
FROM dual;

SELECT SUBSTR('abcde', -2, 2) -- 
FROM dual;

--#4107
SELECT NAME , SUBSTR(JUMIN, 1, 6) 생년월일 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

--#4108
SELECT NAME, SUBSTR(JUMIN, 1, 6) 생년월일 
FROM T_STUDENT 
--WHERE SUBSTR(JUMIN, 3, 2) = '08';
WHERE jumin LIKE '__08%';

--#4109
SELECT NAME , JUMIN 
FROM T_STUDENT 
WHERE GRADE = 4 AND SUBSTR(JUMIN , 7, 1) = 2; 

--INSTR() 함수
SELECT INSTR('A*B*C*', '*', 1, 1) FROM dual; --2
SELECT INSTR('A*B*C*', '*', 1, 2) FROM dual; --4
SELECT INSTR('A*B*C*', '*', 3, 2) FROM dual; --6
SELECT INSTR('A*B*C*', '*', -4, 1) FROM dual; --2 음수인덱스의 경우 검색도 음의 방향으로 진행
SELECT INSTR('A*B*C*', '*', -4, 2) FROM dual; -- 0 없으면 0 리턴
SELECT INSTR('A*B*C*', '*', -2, 2) FROM dual; -- 2

--#4110
--SELECT name, TEL, instr(tel, ')', 1, 1) AS 위치
SELECT name, TEL, instr(tel, ')') AS 위치
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

--#4111
SELECT name, tel , SUBSTR(TEL, 1, INSTR(tel, ')' )-1) 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

--#LTRIM(), RTRIM(), TRIM()
SELECT 
	LTRIM('슈퍼슈슈슈퍼퍼슈퍼가맨', '슈퍼') LTRIM,
	LTRIM('슈퍼슈퍼슈가맨', '슈') LTRIM,
	LTRIM('    슈퍼슈퍼슈가맨') LTRIM, -- 디폴트로 '공백' 제거
	RTRIM(' 우측 공백 제거           ') RTRIM,
	TRIM('   슈퍼맨       ') TRIM, -- 좌우공백제거
	LTRIM('*********10000', '*') LTRIM
FROM dual;

--#4117
SELECT * FROM T_DEPT2 ;

SELECT DNAME ,RTRIM(DNAME , '부') RTRIM예제
FROM T_DEPT2 ;

--REPLACE 함수
SELECT REPLACE ('슈퍼맨 슈퍼걸', '슈퍼', '파워') REPLACE
FROM dual;

SELECT REPLACE ('아버지가 방에 들어간다', ' ', '')
FROM dual;

SELECT NAME , REPLACE (NAME , SUBSTR(NAME , 1, 1), '#') 학생 
FROM T_STUDENT WHERE DEPTNO1 = 102;

--#4119
SELECT name, REPLACE (name, SUBSTR(NAME , 2, 1) , '#')
FROM T_STUDENT WHERE DEPTNO1 =101;

--#4120
SELECT NAME, JUMIN ,REPLACE (JUMIN, SUBSTR(JUMIN, 7, 7) , '*******') 
FROM T_STUDENT WHERE DEPTNO1 = 101;

--#4121
--SELECT NAME , TEL , REPLACE (TEL, SUBSTR(TEL , 5, 3) , '###')
SELECT name, tel, REPLACE (TEL , SUBSTR(tel, INSTR(tel, ')') + 1, 3 ), '###') 전화번호
FROM T_STUDENT 
WHERE DEPTNO1 = 102;

