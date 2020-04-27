create TABLE test_emp_a (
			emp_id NUMBER,
			emp_name varchar2(100)
);

create TABLE test_emp_b (
			emp_id NUMBER,
			emp_name varchar2(100)
);

DELETE FROM test_emp_a;
DELETE FROM test_emp_b;

-- 한 row씩 INSERT
INSERT INTO TEST_EMP_A VALUES (101, '장윤성');
INSERT INTO TEST_EMP_b VALUES (201, '고유성');

SELECT * FROM TEST_EMP_a ;
SELECT * FROM TEST_EMP_b ;

-- 동시에  여러개 테이블에 INSERT 하기
-- 다중 테이블 INSERT 구문에 sub query 필요
INSERT ALL 
			INTO TEST_EMP_A  VALUES (102, '조현주')
			INTO TEST_EMP_B VALUES (202, '최현주')
SELECT * FROM dual;

--sub query로 INSERT 가능
INSERT INTO TEST_EMP_A (SELECT 400, '안성원' FROM dual);
INSERT INTO TEST_EMP_b (SELECT 500, '김성원' FROM dual);

-- 테이블 묻고 더블로 가기
INSERT INTO TEST_EMP_A (SELECT * FROM TEST_EMP_A); 
INSERT INTO TEST_EMP_b (SELECT * FROM TEST_EMP_b); 

INSERT INTO TEST_EMP_B (emp_name) (SELECT emp_name FROM test_emp_a);