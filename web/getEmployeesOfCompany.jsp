<%-- 
    Document   : getEmployeesOfCompany
    Created on : Jun 9, 2018, 3:47:38 PM
    Author     : Mayada Saleh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action = "./GetCompanyEmployees" method = "GET">
            <!--<input type="Integer" name="companyId" hidden="" value="${3}"</>--> 
            <input type = "submit" value = "Get Employee of companies" />
        </form>

    </body>
</html>
