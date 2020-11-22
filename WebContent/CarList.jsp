
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Cars Store Application</title>
    <style>
        body,html{
                    background-image      :  url("<c:url value='/images/CarStore1.jpg'/>");
                    background-attachment : fixed;
                    background-position   : center center;
                    background-size       : cover;  
                }
    </style>
</head>

<body  style="background-color: cyan;">
    <div style="text-align: center">
        <h1>Cars Management</h1>
        <h2>
            <a href="/new">Add New Car</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Cars</a>
             
        </h2>
    </div>
    <div align="center">
    
        <h2>List of Cars</h2>
        <table border="1" style="border-spacing: 5px;">
            <tr>
                <th>Matriculation</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${listCar}"  var="car" >
                <tr>
                    <td><c:out value="${car.matriculation}" /></td>
                    <td><c:out value="${car.brand}" /></td>
                    <td><c:out value="${car.model}" /></td>
                    <td><c:out value="${car.price}" /></td>
                    <td>
                        <a href="/edit?matriculation=<c:out value='${car.matriculation}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?matriculation=<c:out value='${car.matriculation}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>