SELECT * FROM T_STUDENT;
--dual은 ROW 1개짜리 dummy TABLE;
SELECT 'abcde' FROM dual;
SELECT '안녕하세요' FROM dual;
SELECT 100 FROM dual;
SELECT 100 +10 FROM dual;

--
SELECT *FROM T_EMP ;
-- * : 모든컬럼'

-- 원하는 컬럼만 조회
SELECT EMPNO , ENAME , COMM 
FROM t_emp;

--
SELECT * FROM T_PROFESSOR ;
SELECT BONUS 
FROM T_PROFESSOR; 

SELECT '안녕하세요' FROM T_PROFESSOR ;

SELECT name, '교수님 사랑해요' FROM T_PROFESSOR ;

--컬럼 별명(alias) 사용한 출력
SELECT STUDNO 학번 , NAME 이름 
FROM T_STUDENT ;

SELECT STUDNO "학번" , name AS 이름
FROM T_STUDENT ;

SELECT STUDNO "학생 학번", name AS 이름
FROM T_STUDENT ;

SELECT EMPNO 사원번호, ename AS 직업
FROM T_EMP ;

SELECT DEPTNO "부서#", DNAME "부서명", loc 위치
FROM T_DEPT ;

--DISTINCT
SELECT * FROM T_EMP ;
SELECT deptno FROM T_EMP ;
SELECT DISTINCT deptno FROM T_EMP ;

SELECT DISTINCT DEPTNO1 
FROM T_STUDENT ;
SELECT DISTINCT JOB 
FROM T_EMP ;

-- || : 필드,문자열 연결연산
SELECT name, POSITION
FROM T_PROFESSOR ;

SELECT name || '-' || POSITION AS 교수님명단
FROM T_PROFESSOR ;

SELECT name || '의 키는 ' || HEIGHT || 'cm. 몸무게는 ' || WEIGHT || 'kg 입니다' AS "학생의 키와 몸무게"
FROM T_STUDENT ;