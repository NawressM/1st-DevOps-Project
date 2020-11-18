<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@page import="java.sql.SQLException"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Error</title>
</head>
<body>
    <div style="text-align: center">
        <h1>Error</h1>
        <h2>
        <%
        	SQLException e = (SQLException) exception;
        	int code = e.getErrorCode();
        	String message = e.getMessage();

        	if (code != 0) {
            	message = code + " : " + message;
        	}
    	%>

    	<label><%=message %></label>

		<br/> 
		</h2>
    </div>
</body>
</html>