<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<%
String category=request.getParameter("category");
out.println("<script>alert('���������� �����Ǿ����ϴ�')</script>");
out.println("<script>location.href='boardManagement.do?category="+category+"'</script>");
%>