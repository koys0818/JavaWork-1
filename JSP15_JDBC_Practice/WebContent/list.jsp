<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<%

	
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
	final String SQL_WRITE_SELECT = "SELECT * FROM writeTab " +
	"ORDER BY wr_uid DESC"; 
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록</title>
<style>
table {width: 100%;}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>


<%
	try{
		Class.forName(driver);
		out.println("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(url, uid, upw);
		out.println("conn 성공" + "<br>");
		
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT);
		
		rs = pstmt.executeQuery();		
		out.println("쿼리성공<br>");
%>
		<hr>
		<h2>리스트</h2>
		<table>
			<tr>
				<th>UID</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
<%
		while(rs.next()){
			out.println("<tr>");
			int uid = rs.getInt("wr_uid");
			String subject = rs.getString("wr_subject");
			String name = rs.getString("wr_user");
			int viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			
			String regdate = "";
			if(d != null){
				regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
						+ new SimpleDateFormat("hh:mm:ss").format(t);
			}
			
			out.println("<td>" + uid + "</td>");
			out.println("<td><a href='view.jsp?uid=" + uid + "'>" + subject + "</a></td>");
			out.println("<td>" + name + "</td>");
			out.println("<td>" + viewcnt + "</td>");
			out.println("<td>" + regdate + "</td>");
			
			
			out.println("</tr>");
		} // end while
%>			
		</table>
		<br>
		<button onclick="location.href='write.jsp'">신규등록</button>		

<%
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

</body>
</html>

