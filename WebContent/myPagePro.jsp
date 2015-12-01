<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% boolean result = (boolean) request.getAttribute("check");
	
	if(result==true) {
		String url="";
		if("학생".equals(session.getAttribute("auth"))) {
			url="studentUpdate.do";			
		}
		else if("교수".equals(session.getAttribute("auth"))) {
			url="professorUpdate.do";
		}
		else if("직원".equals(session.getAttribute("auth"))) {
			url="employeeUpdate.do";
		}
		else if("관리자".equals(session.getAttribute("auth"))) {
			url="adminUpdate.do";
		}
		out.println("<script>location.href='"+url+"';</script>");
	}
	else {
		out.println("<script>alert('비밀번호를 잘못 입력하셨습니다.');history.back();</script>");
	}
%>

