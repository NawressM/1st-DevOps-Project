<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Cars Store Application</title>
</head>
<body>
    <center>
        <h1>Cars Management</h1>
        <h2>
            <a href="/new">Add New Car</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Cars</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${car != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${car == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${car != null}">
                        Edit Car
                    </c:if>
                    <c:if test="${car == null}">
                        Add New Car
                    </c:if>
                </h2>
            </caption>
                <c:if test="${car != null}">
                    <input type="hidden" name="matriculation" value="<c:out value='${car.matriculation}' />" />
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
        </form>
    </div>   
</body>
</html>