SELECT * FROM TEST_MEMBER ;

-- INSERT INTO 테이블이름 

-- UPDATE 테이블이름 SET

-- DELETE FROM 테이블 이름

INSERT INTO TEST_MEMBER values(10, '남윤주', sysdate);
SELECT * FROM TEST_MEMBER ;

INSERT INTO TEST_MEMBER VALUES(22, '이승환', '1994-02-21');
INSERT INTO TEST_MEMBER VALUES(17, '윤종섭', '2019-08-03');
INSERT INTO TEST_MEMBER VALUES('', '이예지', ''); -- 비어 있는 ''는 null값 처리
-- INSERT INTO TEST_MEMBER VALUES(10, '', sysdate);
INSERT INTO TEST_MEMBER VALUES(null, '윤종섭', '2017-01-01');

--dBeaver에서는 기본적으로auto-commit 수행
