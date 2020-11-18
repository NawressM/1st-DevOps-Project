<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Cars Store Application</title>
</head>
<body>
    <div style="text-align: center">
        <h1>Cars Management</h1>
        <h2>
            <a href="/new">Add New Car</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Cars</a>
             
        </h2>
    </div>
    <div align="center">
        <c:if test="${car != null}">
            <form action="update" method="post"></form>
        </c:if>
        <c:if test="${car == null}">
            <form action="insert" method="post"></form>
        </c:if>
        
                <h2>
                    <c:if test="${car != null}">
                        Edit Car
                    </c:if>
                    <c:if test="${car == null}">
                        Add New Car
                    </c:if>
                </h2>
        <table border="1" style="border-spacing: 5px;">
                <c:if test="${car != null}">
                    <input type="hidden" name="matriculation" value="<c:out value='${car.matriculation}' />" />
                </c:if>   
                <c:if test="${car == null}">
                    <input type="text" name="matriculation" size="45" value="<c:out value='${car.matriculation}' />" />
                </c:if>          
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="brand" size="45"
                            value="<c:out value='${car.brand}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Author: </th>
                <td>
                    <input type="text" name="model" size="45"
                            value="<c:out value='${car.model}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${car.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
    </div>   
</body>
</html>