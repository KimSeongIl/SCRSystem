<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="article">
<c:if test="${requestScope.error eq \"overlap\" }">
	 <script>
	 	alert('학번이 중복됩니다.');
	 	location.href='signUp.do';
	 </script>
</c:if>
<c:if test="${empty requestScope.error }">
	<script>
		alert('회원가입 되었습니다.');
		location.href="main.do";
	</script>
</c:if>
</div>