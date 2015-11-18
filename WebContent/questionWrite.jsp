<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div id="article">
<br>
<form action="questionInsert.do" method="post">

제목 <input type="text" name="qTitle"><br>
질문 내용 <textarea name="qContent">  </textarea><br>
<input type="submit" value="저장">


</form>



</div>