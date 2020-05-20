<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%--<% response.setStatus(200); --%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>에러 안내</title>
</head>
<body>
에러가 발생했습니다... <br>
예외 타입은 : <%= exception.getClass().getName() %><br>
예외 메시지는 : <%= exception.getMessage() %>

</body>
</html>