<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<%
out.println("<script>alert('정상적으로 수정되었습니다')</script>");
out.println("<script>location.href='boardView.do'</script>");
%>