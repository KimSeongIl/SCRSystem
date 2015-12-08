<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.net.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 다운받을 파일의 이름을 가져옴
		String fileName = (String) request.getAttribute("fileName");

		//다운받을 파일이 저장되어 있는 폴더 이름
		String path = (String) request.getAttribute("path");

		// 다운받을 파일의 전체 경로를 filePath에 저장
		String filePath = path + fileName;
		try {

			out.clear();

			out = pageContext.pushBody();

			// 다운받을 파일을 불러옴
			File file = new File(filePath);
			byte b[] = new byte[4096];

			// page의 ContentType등을 동적으로 바꾸기 위해 초기화시킴
			

		} catch (Exception e) {
		}
	%>
dfdfdfd
</body>
</html>