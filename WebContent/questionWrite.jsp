<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div id="article">
<br>
<form action="questionWrite.do" method="post">

���� <input type="text" name="qName"> �ۼ��� <input type="text" name="qTitle"><br> 
���� ���� <textarea name="qContent">  </textarea><br>
<button type="submit" value="����">


</form>

<form action="#" method="post">
�亯��  <input type="text" name="qAnswer"><br>
�亯 ���� <textarea name="qAnswerContent"> </textarea>
<button type="submit" value="����">


</form>


</div>