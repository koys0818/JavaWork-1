<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String sessionName = "num1";
	
	
	//세션 삭제
	session.removeAttribute(sessionName);
	session.removeAttribute("dateTime");
	
%>

<script>
alert("<%= sessionName %>, <%= "dateTime" %>  세션삭제")
location.href = "sessionList.jsp";
</script>