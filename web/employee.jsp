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
        <form action = "http://localhost:8084/MedicalInsuranceSystem/api/version1/user/insertEmployee" method = "POST">
            Name: <input type = "text" name = "name">
            <br />
            
            mail : <input type = "text" name = "mail">
            <br />

            password <input type = "text" name = "password" />
            <br />
           
            phone1: <input type = "text" name = "phone1" />
            <br />
            phone2: <input type = "text" name = "phone2">
            <br />
            phone3: <input type = "text" name = "phone3" />
            
            <br/>

            Start Date: <input type = "text" name = "start_date">
            <br />
            End Date: <input type = "text" name = "end_date" />
            <br />
            address: <input type = "text" name = "address">
            <br />
            job: <input type = "text" name = "job" />
            <br />
            company id: <input type = "text" name = "company_id">
            <br />
            package type: <input type = "text" name = "packageType" />
            
            <br />
            
        <input type="file" id="fileButton"/>
            
            <progress value="0" max="100" id="progress">0%</progress><br/><br/>
            <input type="text" id="urlImage" name="urlImage"/> </br>   
            <button type="button" id="fileInput" value="upload"></br>
                 </button>
            
            <input type = "submit" value = "insert" />
        </form>
      
        
         <script src="https://www.gstatic.com/firebasejs/5.0.4/firebase.js"></script>
         
           <script src="uploadImage.js"></script>
           
    </body>
</html>
