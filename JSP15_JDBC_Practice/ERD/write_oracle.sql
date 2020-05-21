
/* Drop Tables */

DROP TABLE writeTab CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE writeTab
(
	wr_uid number NOT NULL,
	wr_subject varchar2(40) NOT NULL,
	wr_content clob,	
	wr_user varchar2(20) NOT NULL,
	wr_viewcnt number DEFAULT 0,
	wr_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (wr_uid)
);

-- 시퀀스
CREATE SEQUENCE WRITE_SEQ;

SELECT * FROM writeTab;

- 기본데이터 작성
INSERT INTO writeTab VALUES
(WRITE_SEQ.nextval, '첫째글:방가요', '안녕하세요', '김희철', 0, '2017-03-02');
INSERT INTO writeTab VALUES
(WRITE_SEQ.nextval, '둘째글:헤헤헤','1111', '김수길', 0, '2017-03-02');
INSERT INTO writeTab VALUES
(WRITE_SEQ.nextval, '세째글:힘내세요', '7394', '최진덕' , 0, '2017-08-12');
INSERT INTO writeTab VALUES
(WRITE_SEQ.nextval, '네째글: ... ', '9090', '이혜원', 0, '2018-02-09');
INSERT INTO writeTab VALUES
(WRITE_SEQ.nextval, '다섯째글: 게시판', '7531', '박수찬', 0, sysdate);

SELECT * FROM WRITETAB ;



