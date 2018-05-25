<%-- 
    Document   : newjsp
    Created on : May 22, 2018, 2:52:36 PM
    Author     : Aya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <!-- <body>
         <form action = "http://localhost:8084/lab3_server/rest/test/check" method = "POST">
             Name: <input type="checkbox" name ="tryCheckBox" value="dept">
           <br />
          
           <input type = "submit" value = "insert" />
         </form>
          
     </body>-->

    <body>
        <form action = "http://localhost:8084/MedicalInsuranceSystem/rest/lab/insert" method = "POST">
            Name ar: <input type = "text" name = "lab_name_ar">
            <br />
            Name en: <input type = "text" name = "lab_name_en" />

            Address : <input type = "text" name = "lab_address">
            <br />

            longitude: <input type = "text" name = "lab_longitude" />
            <br />
            latitude: <input type = "text" name = "lab_latitude" />
            <br />

            Start Date: <input type = "text" name = "lab_start_date">
            <br />
            End Date: <input type = "text" name = "lab_end_date" />
            <br />
            Open hour: <input type = "text" name = "lab_open_hour">
            <br />
            Close hour: <input type = "text" name = "lab_close_hour" />
            <br />
            Rate: <input type = "text" name = "lab_rate">
            <br />
            CEO: <input type = "text" name = "lab_ceo" />


            phone1: <input type = "text" name = "phone1" />
            <br />
            phone2: <input type = "text" name = "phone2">
            <br />
            phone3: <input type = "text" name = "phone3" />

            special1: <input type="checkbox" name ="c1" value="special1">
            special2: <input type="checkbox" name ="c2" value="special2"> 
            special3: <input type="checkbox" name ="c3" value="special3"> 
            special4: <input type="checkbox" name ="c4" value="special4">
            special5: <input type="checkbox" name ="c5" value="special5">
            special6: <input type="checkbox" name ="c6" value="special6">
            special7: <input type="checkbox" name ="c7" value="special7">
            special8: <input type="checkbox" name ="c8" value="special8">


            <input type = "submit" value = "insert" />
        </form>
</html>
