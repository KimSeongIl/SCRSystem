<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String category=request.getParameter("category");
out.println("<script>alert('�����Ǿ����ϴ�.')</script>");
out.println("<script>location.href='boardManagement.do?category="+category+"'</script>");

%>