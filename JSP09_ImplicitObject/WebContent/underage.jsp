<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>미성년자 페이지</title>
</head>
<body>
<%! int age; %>
<%
	String str = request.getParameter("age");
	age = Integer.parseInt(str);
%>

당신은 <%= age %>세 입니다.
사이트 이용이 불가능하십니다... <br>
<%= (19 - age) %> 년 뒤에 오십시오
<a href="input_age.html">처음으로</a>

</body>
</html>















