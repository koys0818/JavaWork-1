
DROP TABLE t_emp3 CASCADE CONSTRAINTS ;
CREATE TABLE t_emp3(
			NO NUMBER(4) PRIMARY KEY ,
			name varchar2(10) NOT NULL,
			jumin varchar2(13) NOT NULL UNIQUE ,
			area number(1) CHECK (area < 5),
			deptno varchar2(6) REFERENCES t_dept2(dcode)
);
DROP TABLE t_emp3 CASCADE CONSTRAINTS ;
CREATE TABLE t_emp3(
			NO NUMBER(4) CONSTRAINTS emp3_no_pk PRIMARY KEY ,
			name varchar2(10) constraints emp3_name_nn NOT NULL,
			jumin varchar2(13) CONSTRAINTS emp3_jumin_nn NOT NULL
												       CONSTRAINTS emp3_jumin_uk UNIQUE ,
			area number(1) CONSTRAINTS emp3_area_ck CHECK (area < 5),
			deptno varchar2(6) CONSTRAINTS emp4_deptno_fk REFERENCES t_dept2(dcode)
);

SELECT * FROM t_emp3;

ALTER TABLE t_emp3 ADD  CONSTRAINTS emp3_name_uk unique(name);

ALTER TABLE t_emp3 ADD area CONSTRAINTS emp3_area_nn NOT NULL;

ALTER TABLE t_emp3 MODIFY Area CONSTRAINTS emp3_area_nn NOT null;

CREATE OR REPLACE VIEW v_prof( 번호, 이름, 이메일, 홈페이지)
AS
SELECT PROFNO , NAME , email, HPAGE FROM T_PROFESSOR ;

SELECT * FROM v_prof;

DROP VIEW v_prof;