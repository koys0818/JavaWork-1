
/* Drop Tables */

DROP TABLE test_member CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_member
(
	mb_no number,
	mb_name varchar2(40) NOT NULL,
	mb_birthdate date
);

--시퀀스
DROP  SEQUENCE test_member_seq;
CREATE SEQUENCE test_member_seq;

--화면 표시 세팅 (sqlplus 용)
SET LINESIZE 120;
SET PAGESIZE 120;
COL mb_no FOR 999;
COL mb_name FOR a10;
COL mb_birthdate FOR a14;

DELETE FROM test_member;
SELECT * FROM test_member ORDER BY mb_no DESC;