-- 숫자관련단일행 함수들

--ROUND()
SELECT
	ROUND(12.34) "(12.34)",
	round(12.536) "(12.536)",
	round(12.536, 2) "(12.536, 2)", --소숫점 3자리에서 반올림	
	round(16.345, -1) "(16.345, -1)", --1의 자리에서 반올림	
FROM dual;

-- TRUNC() 함수
SELECT
	'TRUNC',
	TRUNC(12.345) "(12.345)",         -- 소수점 자름 (디폴트)
	TRUNC(12.345, 2) "(12.345, 2)",   -- 소수점 3자리부터 자름
	TRUNC(12.345, -1) "(12.345, -1)"  -- 1의 자리부터 자름
FROM
	dual;

--ROUND(), TRUNC(), CEIL(), FLOOR() 함수 비교
SELECT
	'12.5'  "12.5",
	ROUND(12.5)	"ROUND",
	TRUNC(12.5) "TRUNC",
	CEIL(12.5) "CEIL",
	FLOOR(12.5) "FLOOR"
FROM
	dual;
	
SELECT
	'-12.5'  "-12.5",
	ROUND(-12.5)	"ROUND",
	TRUNC(-12.5) "TRUNC",
	CEIL(-12.5) "CEIL",
	FLOOR(-12.5) "FLOOR"
FROM
	dual;
	
--오라클은 %연산자 없음
--MOD() : 나머지 연산
SELECT 
	mod(12, 10) "mod(12, 10)",
	mod(12.6, 4.1) "mod(12.6, 4.1)"
FROM dual;

--POWER() 제곱
SELECT 
power(3, 2) "POWER(3, 2)",
power(-3, 3) "POWER(-3, 3)",
power(10, -2) "POWER(10, -2)",
power(2 , 1/2) "POWER(2, 1/2)",
power(27 , 1/3) "POWER(27, 1/3)"
FROM dual;