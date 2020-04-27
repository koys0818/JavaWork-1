--t_dept2.dcode 참조예정

SELECT * FROM T_DEPT2 ; --dcode: 1~1011

--#9101
-- 제약조건명을 명시하지 않는 방법

DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3(
		no number(4)  PRIMARY key,
		name varchar2(10) NOT NULL,
		jumin varchar2(13) NOT NULL UNIQUE ,
		area number(1) CHECK(area < 5),
		deptno varchar(6) REFERENCES t_dept2(dcode)
);

--별도의 항목으로 제약조건정의 가능
DROP TABLE t_emp4 CASCADE CONSTRAINT;
CREATE TABLE t_emp4(
		no number(4),
		name varchar2(10) NOT null,
		jumin varchar2(13) NOT null,
		area number(1) ,
		deptno varchar(6),
		PRIMARY KEY(no),
		unique(jumin),
		CHECK (area < 5),
		FOREIGN key(deptno) REFERENCES t_dept2(dcode)
);

--#9002
-- 제약조건명을명시하여 정의
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3(
		no number(4) CONSTRAINT emp3_no_pk  PRIMARY key,
		name varchar2(10) CONSTRAINT emp3_name_nn NOT NULL,
		jumin varchar2(13) CONSTRAINT emp3_jumin_uk UNIQUE
		CONSTRAINT emp3_jumin_nn NOT NULL ,
		area number(1) CONSTRAINT emp3_area_ck CHECK(area < 5),
		deptno varchar(6) CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
);

DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3(
		NO number(4),
		name varchar2(10) CONSTRAINT emp3_name_nn NOT NULL,
		jumin varchar2(13) CONSTRAINT emp3_jumin_nn NOT NULL ,
		area number(1) ,
		deptno varchar(6) ,
		CONSTRAINT emp3_no_pk PRIMARY key(no),
		CONSTRAINT emp3_jumin_uk UNIQUE (jumin),
		CONSTRAINT emp3_area_ck CHECK (area < 5),
		CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);

-- #9003 제약조건 조회하기
SELECT owner, CONSTRAINT_name, constraint_type, status
FROM USER_CONSTRAINTS 
WHERE table_name = 'T_EMP4'
;

--#9004 제약조건에 맞는/위배되는 DML 시도해보기
INSERT INTO t_emp3 values(1, '오라클', '1234561234567', 4, 1000);
--두번 실행하면 오류! ORA-00001: unique constraint (SCOTT0316.EMP3_NO_PK) violated

INSERT INTO t_emp3 values(2, '오라클', '1234561234567', 4, 1000);
--ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated

INSERT INTO t_emp3 values(2, '오라클', '2222222222222222', 4, 1000);
--ORA-12899: value too large for column "SCOTT0316"."T_EMP3"."JUMIN" (actual: 16, maximum: 13)

INSERT INTO t_emp3 values(2, '오라클', '2222222222222', 10, 1000);
--ORA-01438: value larger than specified precision allowed for this COLUMN

INSERT INTO t_emp3 values(2, '오라클', '2222222222222', 3, 2000);
--ORA-02291: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - parent key not FOUND

INSERT INTO t_emp3 (NO,jumin, area, deptno) values(2, '3333333333333', 4, 1001);
--ORA-01400: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")

--INSERT뿐 아니라 UPDATE/DELETE에서도 오류 발생 가능
UPDATE t_emp3 SET area = 10 WHERE NO = 1;

SELECT * FROM t_emp3;
DELETE FROM T_DEPT2 WHERE dcode = 1000;
--ORA-02292: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - child record found

--#9005 테이블 생성후에 ALTER 명령 사용하여 제약조건 추가 가능!
--t_emp4의 name 컬럼 UNIQUE 제약조건 추가

--ALTER ~ADD
--ALTER ~MODIFY
--ALTER ~DROP 

ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_uk unique(name);

--#9006
--t_emp4 area컬럼에 NOT NULL 제약조건 추가
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_area_nn NOT NULL;
--이미 칼럼의기본값이 NULL로 되어있기 때문에add가 아닌 modify로 해야한다

ALTER TABLE t_emp4 MODIFY (area CONSTRAINT emp4_area_nn NOT null);

--#9007 외래키 추가
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN key(name) REFERENCES t_emp2(name);
-- 그냥 실행하면에러다 ORA-02270: no matching unique or primary key for this column-list
-- 참조된 부모테이블의 컬럼은 Primary key거나 UNIQUE 해야한다!

--일단 부모테이블의 name을 UNIQUE로바꾼뒤 위의 쿼리르 다시 실행
ALTER TABLE t_emp2 ADD CONSTRAINT emp2_name_uq unique(name);

--#9008
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3(
		no number(4) CONSTRAINT emp3_no_pk  PRIMARY key,
		name varchar2(10) CONSTRAINT emp3_name_nn NOT NULL,
		jumin varchar2(13) CONSTRAINT emp3_jumin_uk UNIQUE
		CONSTRAINT emp3_jumin_nn NOT NULL ,
		area number(1) CONSTRAINT emp3_area_ck CHECK(area < 5),
		deptno varchar(6) 
				CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
				ON DELETE CASCADE -- 부모삭제되면자식도 삭제
--				ON DELETE set NULL -- 부모삭제되면 null값으로
);


--#9009
ALTER TABLE t_emp4 DROP CONSTRAINT emp4_name_fk; -- 일단 기존제약조건 삭제

ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name)
REFERENCES t_emp2(name) ON DELETE SET NULL; -- 부모 삭제되면 자식은 null로 변환

--disable novalidate

-- #9010
SELECT * FROM t_novalidate;
SELECT * FROM t_validate;

SELECT owner, CONSTRAINT_name, CONSTRAINT_type, STATUS 
FROM USER_CONSTRAINTS 
WHERE table_name = 'T_VALIDATE';

INSERT INTO t_novalidate VALUES (1, 'DDD');

SELECT owner, CONSTRAINT_name, CONSTRAINT_type, STATUS 
FROM USER_CONSTRAINTS 
WHERE table_name = 'T_NOVALIDATE';

ALTER TABLE T_NOVALIDATE 
disable novalidate CONSTRAINT SYS_C007031;

ALTER TABLE T_NOVALIDATE 
enable novalidate CONSTRAINT SYS_C007031;

DELETE FROM T_NOVALIDATE WHERE name = 'DDD';