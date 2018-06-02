<%-- 
    Document   : post
    Created on : Mar 1, 2018, 6:56:00 PM
    Author     : hoda.CO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "http://localhost:8585/MedicalInsuranceSystem/api/version1/hospital/insert" method = "POST">
            Name: <input type = "text" name = "name">
            <br />
            Name in english: <input type = "text" name = "name_english" />

            Address : <input type = "text" name = "address">
            <br />

            longitude: <input type = "text" name = "longitude" />
            <br />
            latitude: <input type = "text" name = "latitude" />
            <br />

            Start Date: <input type = "text" name = "start_date">
            <br />
            End Date: <input type = "text" name = "end_date" />
            <br />
            Open hour: <input type = "text" name = "open_hour">
            <br />
            Close hour: <input type = "text" name = "close_hour" />
            <br />
            Rate: <input type = "text" name = "rate">
            <br />
            CEO: <input type = "text" name = "ceo" />


            phone1: <input type = "text" name = "phone1" />
            <br />
            phone2: <input type = "text" name = "phone2">
            <br />
            phone2: <input type = "text" name = "phone3" />

            dept1: <input type="checkbox" name ="c1" value="dept1">
            dept2: <input type="checkbox" name ="c2" value="dept2"> 
            dept3: <input type="checkbox" name ="c3" value="dept3"> 
            dept4: <input type="checkbox" name ="c4" value="dept4">
            dept5: <input type="checkbox" name ="c5" value="dept5">
            dept6: <input type="checkbox" name ="c6" value="dept6">
            dept7: <input type="checkbox" name ="c7" value="dept7">
            dept8: <input type="checkbox" name ="c8" value="dept8">


            <input type = "submit" value = "insert" />
        </form>
        <form action = "http://localhost:8084/lab3_server/rest/user/get" method = "GET">
            <input type = "submit" value = "retrive" />
        </form>
    </body>
</html>
