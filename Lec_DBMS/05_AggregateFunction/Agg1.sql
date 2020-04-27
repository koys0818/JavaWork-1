SELECT * FROM T_PROFESSOR ;

SELECT COUNT(*), -- 그룹함수에서는 NULL 값은 계산에서제외
COUNT(HPAGE ) 
FROM T_PROFESSOR ; 

SELECT 
COUNT(BONUS ) , sum(BONUS ),
avg(BONUS )
FROM T_PROFESSOR ;

SELECT 
max(HIREDATE ), min(HIREDATE )
FROM T_EMP ;

--null허용 칼럼의 그룹함수 적용시
-- nvl, nvl2 사용해야함
SELECT avg(bonus), avg(NVL (BONUS , 0))
FROM T_PROFESSOR ;

-- t_professor 테이블에서 '학과별'로 교수들의 평균
--SELECT
--**불가능하다! select 절에 group 함수와group함수가 아닌 것과는 같이 출력 불가
--DEPTNO , avg(BONUS )
--FROM T_PROFESSOR ;

SELECT DEPTNO , round(avg(nvl(BONUS, 0)), 1) 보너스평균
FROM T_PROFESSOR 
GROUP BY DEPTNO ;

--#5101
SELECT DEPTNO , POSITION, AVG(pay) 평균급여
FROM T_PROFESSOR 
GROUP BY DEPTNO , POSITION --1. 학과별 그룹핑, 2. 직급별 그룹핑
ORDER BY DEPTNO ASC, POSITION ASC ;

--부서별 평균급여를 출력하되 평균급여가450보다 높은 학과만 출력
SELECT DEPTNO , avg(pay) 평균급여
FROM T_PROFESSOR 
WHERE avg(pay) > 450 -- 그룹함수는 where 절에서 사용불가
GROUP BY DEPTNO ;

-- HAVING : 그룹함수 결과에대한 조건절
SELECT DEPTNO , avg(pay) 평균급여
FROM T_PROFESSOR 
GROUP BY DEPTNO 
HAVING AVG(PAY ) > 300;

--<SELECT 쿼리문 순서>
--SELECT
--FROM
--WHERE
--GROUP BY 
--HAVING
--ORDER BY

--#5102
SELECT MGR 매니저 , COUNT(*) 직원수, SUM(SAL ) , avg(sal), avg(nvl(COMM, 0) )
FROM T_EMP 
WHERE JOB <> 'PRESIDENT'
GROUP BY MGR ;

--#5103
SELECT DEPTNO , COUNT(*) 총인원 , ROUND(AVG(SYSDATE - HIREDATE ), 5) 근속평균, ROUND(avg(PAY)) 급여평균, ROUND(avg(NVL(BONUS, 0))) 보너스평균
FROM T_PROFESSOR 
--WHERE POSITION = '정교수' OR POSITION = '조교수'
WHERE POSITION LIKE '%교수'
GROUP BY DEPTNO ;

--#5104
SELECT DEPTNO1 학과, MAX(WEIGHT ) - min(WEIGHT ) 최대최소몸무게차
FROM T_STUDENT 
GROUP BY DEPTNO1 ;

--#5105
SELECT DEPTNO1, MAX(WEIGHT ) - min(WEIGHT )
FROM T_STUDENT 
GROUP BY DEPTNO1 
HAVING MAX(WEIGHT ) - min(WEIGHT ) >= 30;

SELECT * FROM T_STUDENT  ;