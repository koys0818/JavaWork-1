<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>
<c:choose>
	<c:when test="${result == 0 }">
		<script>
		alert('수정 실패');
		history.back();
		</script>
	</c:when>
	<c:otherwise>
		<script>
		alert('수정 성공');
		location.href = 'view.do?uid=${param.uid}';
		</script>	
	</c:otherwise>

</c:choose>