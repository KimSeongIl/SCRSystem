<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String category=(String)request.getAttribute("category");

out.println("<script>alert('저장이 완료되었습니다!')</script>");
out.println("<script>location.href='boardView.do?category="+category+"'</script>");
%>