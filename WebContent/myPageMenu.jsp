<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="myPageSub">
      <div id="myPageSubDiv">
         <h2>마이페이지</h2>
         <hr>
         <ul>
            <li onclick="location.href='login.do'">정보수정</li>
            <c:if test="${\"학생\" eq sessionScope.auth }">
            	<li onclick="location.href=''">상담내역</li>
            </c:if>
            <li onclick="location.href=''">회원탈퇴</li>
            
         </ul>
      </div>
</div>