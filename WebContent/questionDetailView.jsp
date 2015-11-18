<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ page import="scr.dto.QuestionDTO" %>
    <%@ page import="java.util.*" %>
    
    <c:set var="question" value="${questionList}" scope="request"/>
    <c:set var="qId" value="${questionList.getQid()}"/>
    <c:set var="qName" value="${questionList.getqName()}"/>
    <c:set var="qTitle" value="${questionList.getqTitle()}"/>
    <c:set var="qContent" value="${questionList.getqContent()}"/>
    <c:set var="sessionName" value="${sessionScope.name}"/>
    <c:set var="sessionAuth" value="${sessionScope.auth}"/>
  
    

    
    
    <div id="article">
    
    <div id="questionBorder">
    <table id="question">
    <tr>
    <td>����</td> <td>${qTitle}</td> <td>�ۼ���</td> <td>${qName }</td>
    </tr>
    <tr>
    <td>����</td> <td colspan="3">${qContent}</td>
    </tr>
    </table>
    </div>
    
    <!--  �����϶���  -->
 
	
    <div id="answerBorder" >
    
    <table>
    <tr>
    <td><input type="hidden" value="${sessionName}" name="answerName" /><textarea class="form-control" name="aContent"></textarea></td> <td><button type="submit" onclick="answerWrite(${qId})">�亯����</button></td>
    </tr>
    </table>
    
    </div>
  
    
    <button class="btn btn-default" onclick="history.back()">���</button>
    </div>
    
    
    <link rel="stylesheet" type="text/css" href="assets/css/question.css">
    <script src="assets/js/question.js"></script>
    