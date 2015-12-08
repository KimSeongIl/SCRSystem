<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String category=request.getParameter("category");
out.println("<script>alert('삭제되었습니다.')</script>");
out.println("<script>location.href='boardManagement.do?category="+category+"'</script>");

%>