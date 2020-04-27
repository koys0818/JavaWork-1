-- 계층형쿼리(Hierachical Query)

SELECT * FROM T_DEPT2 ; -- 서로의 계층관계 주목!

SELECT lpad(dname, 10, '*') 부서명 FROM T_DEPT2 ;

-- LEVEL
SELECT DNAME , LEVEL 
FROM T_DEPT2 
CONNECT BY PRIOR dcode = PDEPT 
START WITH DCODE = 0001
;
/* 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR  :  각 row 들이 어떻게 연결되어야 하는지 조건 지정
 * PRIOR를 어느쪽에 주느냐가 중요!
 */

-- PRIOR를 다른데 주면 ?
SELECT DNAME , LEVEL 
FROM T_DEPT2 
CONNECT BY dcode = PRIOR PDEPT 
START WITH DCODE = 0001
;

SELECT DCODE ,DNAME , LEVEL 
FROM T_DEPT2 
CONNECT BY dcode = PRIOR PDEPT 
START WITH DCODE = 1011
;

SELECT LPAD(DNAME , LEVEL *6, '*') 부서명
FROM T_DEPT2 
CONNECT BY PRIOR dcode = PDEPT 
START WITH DCODE = 0001
;

SELECT * FROM T_EMP2 ;

SELECT LPAD(e.NAME  || ' ' || d.dname || ' ' || nvl(e.POST, '사원' ), LEVEL *20, '-') "이름과 직급"
FROM T_EMP2 e, (SELECT dname, dcode, PDEPT FROM T_DEPT2) d
WHERE e.DEPTNO = d.dcode
CONNECT BY PRIOR e.EMPNO = e.PEMPNO 
START WITH e.EMPNO = 20000101
;

SELECT LEVEL - 1
FROM DUAL 
CONNECT BY LEVEL <= 24
;

--입양시각 구하기(2)
--https://programmers.co.kr/learn/courses/30/lessons/59413?language=oracle
select h.hr "HOUR", count(datetime) "COUNT"
from (select level-1 hr from dual connect by level <= 24) h
    left outer join animal_outs a
    on h.hr = to_number(to_char(a.datetime, 'hh24'))
    group by h.hr
    order by 1
;