-- 비등가 조인(Non-Equi Join)

SELECT * FROM T_CUSTOMER ;
SELECT * FROM T_GIFT ;

--Oracle
SELECT c.C_NAME "고객명" , c.C_POINT "POINT" , g.G_NAME "상품명"
FROM T_CUSTOMER c, T_GIFT g
WHERE c.C_POINT BETWEEN g.G_START AND g.G_END 
;

--ANSI
SELECT c.C_NAME "고객명" , c.C_POINT "POINT" , g.G_NAME "상품명"
FROM T_CUSTOMER c JOIN T_GIFT g
ON  c.C_POINT BETWEEN g.G_START AND g.G_END 
;

--#6201
--Oracle
SELECT g.G_NAME "상품명", COUNT(*) "필요수량"
FROM T_CUSTOMER c, T_GIFT g
WHERE c.C_POINT BETWEEN g.G_START AND g.G_END 
GROUP BY g.G_NAME 
;

--ANSI
SELECT g.G_NAME "상품명", COUNT(*) "필요수량"
FROM T_CUSTOMER c JOIN  T_GIFT g
ON  c.C_POINT BETWEEN g.G_START AND g.G_END 
GROUP BY g.G_NAME 
;

--#6203
SELECT *  FROM T_STUDENT ;
SELECT * FROM T_EXAM01 ;
SELECT * FROM T_CREDIT ;

--Oracle
SELECT s.NAME "학생이름" , e.TOTAL "점수" , c.GRADE "학점"
FROM T_STUDENT s , T_EXAM01 e , T_CREDIT c 
WHERE s.STUDNO = e.STUDNO
AND e.TOTAL BETWEEN c.MIN_POINT AND c.MAX_POINT 
ORDER BY e.TOTAL DESC 
;

--ANSI
SELECT s.NAME "학생이름" , e.TOTAL "점수" , c.GRADE "학점"
FROM T_EXAM01 e JOIN T_STUDENT s   ON s.STUDNO = e.STUDNO
 JOIN T_CREDIT c ON e.TOTAL BETWEEN c.MIN_POINT AND c.MAX_POINT 
ORDER BY e.TOTAL DESC 
;

--#6204
--Oracle
SELECT c.C_NAME "고객명", c.C_POINT "뽀인트", g.G_NAME "상품명"
FROM T_CUSTOMER c, T_GIFT g
WHERE c.C_POINT >= g.G_START AND g.G_NAME = '산악용자전거'
;

--ANSI
SELECT c.C_NAME "고객명", c.C_POINT "뽀인트", g.G_NAME "상품명"
FROM T_CUSTOMER c JOIN T_GIFT g
ON c.C_POINT >= g.G_START
WHERE g.G_NAME = '산악용자전거'
;

--#6205
-- Oracle
SELECT e.NAME "이름", 
			TO_CHAR(SYSDATE, 'YYYY') -  TO_CHAR(e.BIRTHDAY, 'YYYY') + 1 "현재나이", 
			nvl(e.POST, ' ') "현재직급", p.POST "예상직급"
FROM T_EMP2 e, T_POST p
WHERE 
			TO_CHAR(SYSDATE, 'YYYY') -  TO_CHAR(e.BIRTHDAY, 'YYYY') + 1 
			BETWEEN p.S_AGE AND p.E_AGE 
;

-- ANSI
SELECT e.NAME "이름", 
			TO_CHAR(SYSDATE, 'YYYY') -  TO_CHAR(e.BIRTHDAY, 'YYYY') + 1 "현재나이", 
			nvl(e.POST, ' ') "현재직급", p.POST "예상직급"
FROM T_EMP2 e JOIN  T_POST p
ON 
			TO_CHAR(SYSDATE, 'YYYY') -  TO_CHAR(e.BIRTHDAY, 'YYYY') + 1 
			BETWEEN p.S_AGE AND p.E_AGE 
;

--OUTER JOIN
--ANSI구문만 존재
--#6206
SELECT s.NAME "학생이름", p.NAME "교수이름"
FROM T_STUDENT s LEFT OUTER JOIN  T_PROFESSOR p
				ON s.PROFNO = p.PROFNO 
;

SELECT s.NAME "학생이름", p.NAME "교수이름"
FROM T_STUDENT s RIGHT  OUTER JOIN  T_PROFESSOR p
				ON s.PROFNO = p.PROFNO 
;

SELECT s.NAME "학생이름", p.NAME "교수이름"
FROM T_STUDENT s FULL  OUTER JOIN  T_PROFESSOR p
				ON s.PROFNO = p.PROFNO 
;

--#6209
SELECT * FROM T_DEPT2 ;

SELECT d1.DNAME "부서명", d2.DNAME "상위부서명"
FROM T_DEPT2 d1, T_DEPT2 d2
WHERE d1.PDEPT = d2.DCODE ;

SELECT d1.DNAME "부서명", d2.DNAME "상위부서명"
FROM T_DEPT2 d1 join T_DEPT2 d2
ON  d1.PDEPT = d2.DCODE ;

--#6210
SELECT * FROM T_PROFESSOR ;

SELECT p1.PROFNO "교수번호", p1.NAME "교수명", TO_CHAR(p1.HIREDATE, 'YYYY-MM-DD') "입사일" ,
COUNT(p2.HIREDATE) "빠른분들"
FROM T_PROFESSOR p1 LEFT OUTER  JOIN T_PROFESSOR p2
ON p2.HIREDATE < p1.HIREDATE
GROUP BY p1.PROFNO , p1.NAME , p1.HIREDATE 
ORDER BY 4
;