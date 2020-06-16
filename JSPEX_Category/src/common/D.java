package common;

/*
 * DB 접속 정보, 쿼리문, 테이블명, 컬럼명 등은
 * 별도로 관리하든지
 * XML, 초기화 파라미터 등에서 관리하는 것이 좋다.
 */
public class D {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";  // JDBC 드라이버 클래스
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";  // DB 접속 URL
	public static final String USERID = "scott0316";  // DB 접속 계정 정보
	public static final String USERPW = "tiger0316";
	
	
	// 특정 depth의 카테고리들 읽어오기
	public static final String SQL_CATEGORY_SELECT_DEPTH = 
			"SELECT ca_uid \"uid\", ca_name name, ca_depth DEPTH, ca_parent parent, ca_order \"order\" " + 
					"FROM TEST_CATEGORY " + 
					"WHERE ca_depth = ? " + 
					"ORDER BY ca_order ASC"
					;
	
	// 특정 depth의 특정 parent인 카테고리들 읽어오기
	public static final String SQL_CATEGORY_SELECT = 
			"SELECT ca_uid \"uid\", ca_name name, ca_depth DEPTH, ca_parent parent, ca_order \"order\" " + 
			"FROM TEST_CATEGORY " + 
			"WHERE ca_depth = ? AND ca_parent = ? " + 
			"ORDER BY ca_order ASC"
			;
}




























