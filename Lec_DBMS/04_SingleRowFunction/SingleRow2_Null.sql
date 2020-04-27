SELECT * FROM T_PROFESSOR ;

--null 값과의 산술 연산 결과는null 이다!
SELECT name, PAY , BONUS , PAY + BONUS 
FROM T_PROFESSOR ;

--그룹함수에서는 동작!, null은 연산에서 제외되어 동작
SELECT sum(pay), sum(BONUS ) FROM T_PROFESSOR ;

-- nvl() 함수
SELECT name, PAY , BONUS ,
					PAY + BONUS 총지급액,
					pay + nvl(BONUS , 0) 총지급액
FROM T_PROFESSOR ;

--#4201
SELECT NAME , PAY , nvl(BONUS, 0) BONUS, PAY *12 + nvl(BONUS , 0) 연봉
FROM T_PROFESSOR 
WHERE DEPTNO = 101;

--#4202
SELECT NAME , PAY , nvl2(BONUS, BONUS , 0) BONUS, NVL2(BONUS , PAY *12 + BONUS , PAY *12) 연봉
FROM T_PROFESSOR 
WHERE DEPTNO = 101;