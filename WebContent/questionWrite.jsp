<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" type="text/css" href="assets/css/question.css">


<div id="article">
<br>
<form action="questionInsert.do" method="post">

<input type="text" name="qTitle" class="form-control" placeholder="Q&A 제목을 적어주세요 "><br>

<textarea  class="form-control" rows="5" name="qContent" placeholder="질문 내용을 적어주세요 " ></textarea><br>
<input id="questionSave" type="submit" class="btn btn-primary" value="저장">


</form>



</div>