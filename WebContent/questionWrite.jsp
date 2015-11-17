<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div id="article">
<br>
<form action="questionWrite.do" method="post">

제목 <input type="text" name="qName"> 작성자 <input type="text" name="qTitle"><br> 
질문 내용 <textarea name="qContent">  </textarea><br>
<button type="submit" value="저장">


</form>

<form action="#" method="post">
답변자  <input type="text" name="qAnswer"><br>
답변 내용 <textarea name="qAnswerContent"> </textarea>
<button type="submit" value="저장">


</form>


</div>