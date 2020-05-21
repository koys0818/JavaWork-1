<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>

<%
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");

	if(name == null || subject == null ||
			name.trim().equals("") || subject.trim().equals("")){
%>
		<script>
			alert("작성자이름, 글제목을 입력하세요!!!!");
			history.back();
		</script>
<%
		return;		
	}
	
%>


<%!
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int cnt = 0;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott0316";
	String upw = "tiger0316";

%>


<%!
	final String SQL_WRITE_INSERT = "INSERT INTO writeTab " +
	"(wr_uid, wr_subject, wr_content, wr_user)" + 
	"VALUES(write_seq.nextval, ?, ?, ?)";
%>

<%
	try{
		Class.forName(driver);
		out.println("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(url, uid, upw);
		out.println("conn 성공" + "<br>");
		
		pstmt = conn.prepareStatement(SQL_WRITE_INSERT);
		
		pstmt.setString(1, subject);
		pstmt.setString(2, content);
		pstmt.setString(3, name);
		
		cnt = pstmt.executeUpdate();
		
		
		
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
%>

<%	if(cnt == 0){ %>
	<script>
		alert("등록 실패!!!!!!");
		history.back();
	</script>
	
<%} else { %>
	<script>
		alert("등록 성공! 리스트 출력합니다");
		location.href="list.jsp";
	</script>
	
<% } %>
