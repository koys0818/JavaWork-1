
/* Drop Tables */

DROP TABLE phonebook CASCADE CONSTRAINTS;


/* Create Tables */

CREATE TABLE phonebook
(
	pb_uid number NOT NULL,
	pb_name varchar2(40) NOT NULL,
	pb_phonenum varchar2(40),
	pb_memo clob,
	pb_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pb_uid)
);


-- 시퀀스 객체도 생성하자
DROP SEQUENCE phonebook_seq;
CREATE SEQUENCE phonebook_seq;

SELECT * FROM PHONEBOOK ;

SELECT COUNT(*) cnt FROM test_member ; -- 테이블의 모든 레코드 개수
SELECT max(mb_no) FROM TEST_MEMBER; -- mb_no의 최댓값
SELECT min(mb_no) min FROM TEST_MEMBER; -- mb_no의 최댓값

SELECT COUNT(*) cnt FROM PHONEBOOK ;

SELECT * FROM seq WHERE SEQUENCE_NAME = 'PHONEBOOK_SEQ';
 
SELECT * FROM phonebook ORDER BY pb_uid desc;