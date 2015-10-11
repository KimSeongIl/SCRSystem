<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div id="article" >
	
<% 
System.out.println("제목:"+request.getParameter("title"));
System.out.println("내용:"+request.getParameter("content"));
	%>

	</div>
	
	
	

