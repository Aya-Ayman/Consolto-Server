<%-- 
    Document   : pharmacy
    Created on : Jun 7, 2018, 5:17:04 PM
    Author     : Aya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "http://localhost:8084/MedicalInsuranceSystem/api/version1/pharmacy/insert" method = "POST">
            Name in arabic: <input type = "text" name = "pharmacy_name_ar">
            <br />
            Name in english: <input type = "text" name = "pharmacy_name_en" />

            Address : <input type = "text" name = "pharmacy_address">
            <br />

            longitude: <input type = "text" name = "pharmacy_longitude" />
            <br />
            latitude: <input type = "text" name = "pharmacy_latitude" />
            <br />

            Start Date: <input type = "text" name = "pharmacy_start_date">
            <br />
            End Date: <input type = "text" name = "pharmacy_end_date" />
            <br />
            Open hour: <input type = "text" name = "pharmacy_open_hour">
            <br />
            Close hour: <input type = "text" name = "pharmacy_close_hour" />
            <br />
            Rate: <input type = "text" name = "pharmacy_rate">
            <br />
            <!--CEO: <input type = "text" name = "ceo" />-->


            phone1: <input type = "text" name = "phone1" />
            <br />
            phone2: <input type = "text" name = "phone2">
            <br />
            phone2: <input type = "text" name = "phone3" />

        

                
        <input type="file" id="fileButton"/>
            
            <progress value="0" max="100" id="progress">0%</progress><br/><br/>
            <input type="text" id="urlImage" name="urlImage"/> </br>   
            <button type="button" id="fileInput" value="upload"></button></br>
            
            <input type = "submit" value = "insert" />
            
            
        </form>
        
         
         <script src="https://www.gstatic.com/firebasejs/5.0.4/firebase.js"></script>
         
           <script src="uploadImage.js"></script>
    </body>
</html>
