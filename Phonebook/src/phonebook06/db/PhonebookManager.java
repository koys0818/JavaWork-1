package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb, Closeable {

	// TODO : DB를 위한 변수들 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// singleton 적용
	private PhonebookManager() {

		// TODO
		// JDBC 프로그래밍

		try {

			// 클래스 로딩
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");

			// 연결 Connection(프로그램 가동되는 동안 계속 유지되어야 함)
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connect 성공");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}

	// 전화번호부 생성등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		// 매개변수 검증 : 이름 필수
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
		}

		int cnt = 0;

		// TODO
		// SQL_INSERT 사용하여 INSERT
		// PreparedStatement 사용 + close()

		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) INSERT 성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cnt;
	}

	@Override
	public PhonebookModel[] selectAll() {

		PhonebookModel[] pbmodels = null;

		// TODO
		// SQL_SELECT_ALL 사용

		try {
			pstmt = conn.prepareStatement(SQL_COUNT_ALL);
			rs = pstmt.executeQuery();
			int cnt = 0;
			while (rs.next()) {

				cnt = rs.getInt("CNT");
			}

			rs.close();
			pstmt.close();

			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();

			pbmodels = new PhonebookModel[cnt];
			int i = 0;

			while (rs.next()) {
				int uid = rs.getInt(COL_LABEL_UID);
				String name = rs.getString(COL_LABEL_NAME);
				String phoneNum = rs.getString(COL_LABEL_PHONENUM);
				String memo = rs.getString(COL_LABEL_MEMO);
				String regDate = "";
				
				Date d = rs.getDate(COL_LABEL_REGDATE); // 날짜만 가져옵니다
				Time t = rs.getTime(COL_LABEL_REGDATE); // 시간만 가져옵니다
				
				if(d != null) {
					regDate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
							+ new SimpleDateFormat("hh:mm:ss").format(t)
							;
				}
				
				SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				java.util.Date regdate = null;
				try {
					regdate = fm.parse(regDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pbmodels[i] = new PhonebookModel(uid, name, phoneNum, memo, regdate);
				i++;
			}

			return pbmodels;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
	}

	// 특정 uid의 데이터 검색 리턴
	// 못 찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {	
		
		PhonebookModel pbmodel = null;

		try {

			pstmt = conn.prepareStatement(SQL_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			

			while (rs.next()) {
				int pb_uid = rs.getInt(COL_LABEL_UID);
				String name = rs.getString(COL_LABEL_NAME);
				String phoneNum = rs.getString(COL_LABEL_PHONENUM);
				String memo = rs.getString(COL_LABEL_MEMO);
				String regDate = "";
				
				Date d = rs.getDate(COL_LABEL_REGDATE); // 날짜만 가져옵니다
				Time t = rs.getTime(COL_LABEL_REGDATE); // 시간만 가져옵니다
				
				if(d != null) {
					regDate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
							+ new SimpleDateFormat("hh:mm:ss").format(t)
							;
				}
				
				SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				java.util.Date regdate = null;
				try {
					regdate = fm.parse(regDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pbmodel = new PhonebookModel(pb_uid, name, phoneNum, memo, regdate);				
			}

			return pbmodel;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);

		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING); // 이름 필수

		int cnt = 0;

		// TODO
		// SQL_UPDATE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) UPDATE 성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 1;
	}

	@Override
	public int deleteByUid(int uid) {

		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);

		int cnt = 0;

		// TODO
		// SQL_DELETE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) DELETE 성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 1;
	}

	// 현재 데이터 중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;

		// TODO : 옵션
		

		return maxUid;
	}

	@Override
	public void close() throws IOException {

		// TODO
		// ResultSet
		// Statement
		// Connection
		// 들 close()...

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
} // end PhonebookManager

// 예외 클래스 정의
// 예외 발생하면 '에러코드' + '에러메시지'를 부여하여 관리하는게 좋다.

class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}
}
