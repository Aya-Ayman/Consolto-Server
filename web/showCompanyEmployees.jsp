<%-- 
    Document   : showCompanyEmployees
    Created on : Jun 10, 2018, 4:07:06 AM
    Author     : Mayada Saleh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h3> My name is ${employeeList.name}</h3>
        <h3> My email is ${employeeList.email}</h3>
        </br>
        
        <table>
            <c:forEach items="${employeeList}" var="item">
                <tr>
                    <td><c:out value="${item.name}" /></td>
                    <td><c:out value="${item.email}" /></td>
                </tr>
            </c:forEach>
        </table>


    </body>
</html>
