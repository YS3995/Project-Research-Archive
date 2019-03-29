<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!--    <%@page import="com.nilesh.DAO.*" %>
    <%@page import="com.nilesh.model.*" %>  -->
<%
System.out.println("logincheck.jsp");
String name=request.getParameter("uname");
String pass=request.getParameter("pass");
response.sendRedirect("index.jsp");


%>