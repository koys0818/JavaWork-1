<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Arrays" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>request parameter</title>
</head>
<body>
<%!
	String data1, data2;
	String name, id, pw, gender, local, memo;
	String [] hobbys;
	
%>

<%
	request.setCharacterEncoding("utf-8");
	data1 = request.getParameter("data1");
	data2 = request.getParameter("data2");
	name = request.getParameter("name");
	hobbys = request.getParameterValues("hobby");
	
	//TODO
%>

hidden : <%= data1 %>, <%= data2 %><br>
이름 : <%= name %><br>
취미 : <%= Arrays.toString(hobbys) %><br>

<%-- TODO --%>

</body>
</html>















