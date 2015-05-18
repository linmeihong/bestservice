<%@page import="com.best.util.AppLogger"%>
<%@page import="com.best.domain.ReceiveXmlEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hello
<%
	for(ReceiveXmlEntity rxe : AppLogger.getMsgList()){
		out.println("from:"+rxe.getFromUserName()+"<br/>");
		out.println("to:"+rxe.getToUserName()+"<br/>");
		out.println("content:"+rxe.getContent()+"<br/>");
	}
%>
<br/>
xml source:<br/>
<%
	for(String rxe : AppLogger.getMsgSourceList()){
		out.println(rxe+"<br/>");
	}
%>
<br/>
xml Result:<br/>
<%
	for(String rxe : AppLogger.getMsgResultList()){
		out.println(rxe+"<br/>");
	}
%>

</body>
</html>