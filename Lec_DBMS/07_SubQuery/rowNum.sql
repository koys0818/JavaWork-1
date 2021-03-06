-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

SELECT EMPNO , ENAME , SAL 
FROM T_EMP 
;

-- 자동적으로 오라클에서 붙여주는 행번호 객체(ROWNUM)
SELECT rownum, EMPNO , ENAME , SAL 
FROM T_EMP 
;

--직원번호 역순이지만 Rownum은 1~
SELECT rownum, EMPNO , ENAME , SAL 
FROM T_EMP 
ORDER BY EMPNO DESC 
;

SELECT rownum, EMPNO , ENAME , SAL 
FROM T_EMP 
WHERE ROWNUM <= 5
ORDER BY EMPNO DESC 
;

--select에 rownum 없어도 동작
SELECT EMPNO , ENAME , SAL 
FROM T_EMP 
WHERE ROWNUM <= 5
ORDER BY EMPNO DESC 
;

-- ROWNUM > 5 ??? 동작안함... ROWNUM 범위가 1이 포함안되면 동작안함
SELECT rownum, EMPNO , ENAME , SAL 
FROM T_EMP 
WHERE ROWNUM > 5
ORDER BY EMPNO DESC 
;

--(1page)
SELECT rownum, EMPNO , ENAME , SAL 
FROM T_EMP 
WHERE rownum >=1 AND  ROWNUM < 1 + 5
ORDER BY EMPNO DESC 
;
--(2page), 안나온다...
SELECT rownum, EMPNO , ENAME , SAL 
FROM T_EMP 
WHERE rownum >=6 AND  ROWNUM < 6 + 5
ORDER BY EMPNO DESC 
;

--phonebook 뻥튀기..
SELECT * FROM PHONEBOOK ;
INSERT INTO PHONEBOOK (SELECT * FROM PHONEBOOK ); -- 에러 PRIMARY key중복

INSERT INTO PHONEBOOK 
(SELECT phonebook_seq.nextval, pb_name, pb_phonenum, PB_MEMO, SYSDATE FROM PHONEBOOK );

--rownum ver
SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC ;

SELECT T.*
FROM (SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC) T;

SELECT Rownum AS rnum, t.*
FROM (SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC) T;

SELECT * FROM 
(
SELECT Rownum AS rnum, t.*
FROM (SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC) T
)
WHERE RNUM  >= 6 AND  RNUM < 6 + 5;

SELECT * FROM 
(
SELECT Rownum AS rnum, t.*
FROM (SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC) T
)
WHERE RNUM  >= 16 AND  RNUM < 16 + 5;


--한 페이지당 10개 데이터
--3번쨰 페이지
SELECT * FROM 
(
SELECT Rownum AS rnum, t.*
FROM (SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID DESC) T
)
WHERE RNUM  >= 21 AND  RNUM < 16 + 10;