CREATE OR REPLACE VIEW v_prof
AS
SELECT PROFNO , NAME , EMAIL , HPAGE 
FROM T_PROFESSOR 
;

SELECT * FROM v_prof;

SELECT tname FROM tab;

--View 생성시 별도의 컬럼이름을 지정해 줄 수 있다.
CREATE OR REPLACE VIEW v_prof(pfno, nm, em ,hp)
AS
SELECT PROFNO , NAME , EMAIL , HPAGE 
FROM T_PROFESSOR 
;

--#8102
CREATE OR REPLACE VIEW v_prof_dept(교수번호, 교수이름, 학과명)
AS
SELECT p.PROFNO , p.NAME , d.DNAME 
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO 
;
SELECT * FROM v_prof_dept;

--#8103
SELECT DEPTNO1 , max(HEIGHT ), max(WEIGHT )
FROM T_STUDENT 
GROUP BY DEPTNO1 
;

SELECT 
d.DNAME , s.max_height, s.max_weight
FROM 
(SELECT DEPTNO1 , max(HEIGHT ) max_height, max(WEIGHT ) max_weight
FROM T_STUDENT GROUP BY DEPTNO1 ) s, 
t_department d
WHERE 
s.deptno1 = d.DEPTNO ;

--#8104
SELECT d.DNAME "학과명", a.max_height "최대키", s.NAME "학생이름", s.HEIGHT "키"
FROM
			(SELECT DEPTNO1 ,max(HEIGHT) max_height FROM T_STUDENT GROUP BY DEPTNO1) a,
			t_student s, t_department d	
WHERE 
			s.DEPTNO1 = a.deptno1 AND s.HEIGHT = a.max_height AND s.DEPTNO1 = d.DEPTNO 
;

--#8105
SELECT s.GRADE , s.NAME , s.HEIGHT , a.avg_height
FROM 
(SELECT GRADE , avg(HEIGHT) avg_height FROM T_STUDENT GROUP BY GRADE ) a, 
t_student s
WHERE a.grade = s.GRADE AND s.HEIGHT > a.avg_height
ORDER BY 1
;