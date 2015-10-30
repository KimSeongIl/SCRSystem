<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="assets/css/myPage.css">
<div id="article">

	<c:import url="myPageMenu.jsp" />
	
	<div id="myPagePW">
		
		<hr>
		<form method="post" action="myPageCheck.do">
			<table>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" placeholder="password" class="form-control"></td>
					<td><input type="submit" class="btn btn-privary" value="확인"></td>
				</tr>		
			</table>
		</form>
	</div>
</div>

