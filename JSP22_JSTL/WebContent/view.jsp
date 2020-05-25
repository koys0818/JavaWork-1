<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   

<c:choose>
	<c:when test="${empty view  || fn:length(view) == 0}">
		<script>
			alert("해당정보가 삭제되거나 없습니다");
			history.back();
		</script>	
	</c:when> 
	<c:otherwise>	

<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>읽기 ${view[0] }</title> <!-- title에 글제목 넣기 -->
</head>
<script>
function chkDelete(uid){
	var r = confirm("삭제하시겠습니까?");
	if(r){
		location.href = 'deleteOk.do?uid=' + uid;
	}
}

</script>
<body>
<h2>읽기 ${view[0].subject }</h2>
<br>
UID : ${view[0].uid }<br>
작성자 : ${view[0].name }<br>
제목 : ${view[0].subject }<br>
등록일 : ${view[0].regDate }<br>
조회수 : ${view[0].viewCnt }<br>
내용 : <br>
<hr>
<div>
${view[0].content }
</div>
<hr>
<br>
<button onclick="location.href= 'update.do?uid=${view[0].uid }'">수정하기</button>
<button onclick="location.href = 'list.do'">목록보기</button>
<button onclick="chkDelete(${view[0].uid })">삭제하기</button>
<button onclick="location.href = 'write.do'">신규등록</button>

</body>
</html>

	</c:otherwise>
</c:choose>	