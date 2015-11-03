<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
System.out.println("isnert_>"+request.getParameter("title"));
System.out.println("insert->"+request.getParameter("content"));
out.println("<script>alert('저장이 완료되었습니다!')</script>");
out.println("<script>location.href='noticeView.do'</script>");
%>