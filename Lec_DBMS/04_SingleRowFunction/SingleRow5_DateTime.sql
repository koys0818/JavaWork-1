-- 날짜 함수
SELECT SYSDATE
FROM dual;

--기본적인 날짜 연산
SELECT 
SYSDATE "오늘",
SYSDATE + 1"24hr뒤" ,
SYSDATE - 2"48hr앞" ,
SYSDATE + 1/24"1hr뒤" 
FROM DUAL ;

-- 일자 차이 계산
SELECT 
sysdate "오늘",
TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD hh:mi:ss') "시작한 날",
SYSDATE  - TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD hh:mi:ss') "경과"
FROM dual;

--MONTHS_BETWEEN : 날짜 사이의 개월수
SELECT 
-- 규칙1: 두 날짜 중 큰 날짜를 먼저 써야 양수값으로 나옴
MONTHS_BETWEEN('2012-03-01', '2012-01-01') "양수값" ,
MONTHS_BETWEEN('2012-01-01', '2012-03-01') "음수값", 
-- 규칙2: 두 날짜가 같은 달에 속해 있으면 특정 규칙으로 계산된 값
MONTHS_BETWEEN('2012-02-29', '2012-02-01') "2/29-2/01",
MONTHS_BETWEEN('2012-04-30', '2012-04-01') "4/30-4/01",
MONTHS_BETWEEN('2012-05-31', '2012-05-01') "5/31-5/01"
FROM dual;

--#4501
SELECT 
NAME "이름" , 
TO_CHAR( SYSDATE, 'yyyy-mm-dd') 오늘,
TO_CHAR(HIREDATE, 'yyyy-mm-dd') 입사일,
TO_CHAR( SYSDATE, 'yyyy') - TO_CHAR(HIREDATE, 'yyyy') 근속연수 ,
ROUND( MONTHS_BETWEEN(SYSDATE, HIREDATE ), 1) 근속개월 ,
round(SYSDATE - HIREDATE, 1) 근속일
FROM T_PROFESSOR ;

-- add_month() 개월 추가
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 3 ) FROM dual;  

SELECT 
SYSDATE,
LAST_DAY(sysdate) "이번달 마지막날",
NEXT_DAY(SYSDATE, '월' ) "다음 월요일" 
FROM dual

SELECT
SYSDATE,
ROUND(SYSDATE),
Trunc(SYSDATE )
FROM dual;