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
       <form action = "http://localhost:4048/MedicalInsuranceSystem/api/version1/company/insert" method = "POST">
         company Name: <input type = "text" name = "name">
         <br />
         company Email: <input type = "text" name = "email" />
         <br/>
         company Latitude: <input type = "text" name = "latitude">
         <br />
         company Longitude: <input type = "text" name = "longitude" />
         <br/>
          company Address: <input type = "text" name = "address">
         <br />
         company Package: <input type = "text" name = "companyPackage" />
         <br/>
         company Start Date: <input type = "text" name = "startDate">
         <br />
         company End Date: <input type = "text" name = "endDate" />
          <br/>
         company CEO: <input type = "text" name = "ceo">
         <br />
         company insurance Id: <input type = "text" name = "insuranceId" />
         <br />
         phone 1: <input type = "text" name = "phone1" />
          <br/>
         phone 2: <input type = "text" name = "phone2">
         <br />
         phone 3: <input type = "text" name = "phone3" />
         <br/>
         <input type = "submit" value = "insert" />
          <br /> <br /> <br /> <br />
       </form>
         
         <form action = "http://localhost:8084/MedicalInsuranceSystem/rest/user/insertEmployee" method = "POST"> 
        
            Name: <input type = "text" name = "name">
            <br />
            Mail: <input type = "text" name = "mail" />
            <br />
            Password: <input type = "text" name = "password" /> 
            <br />
            Company ID: <input type = "text" name = "company_id" /> 
            <br />
            
<!--            employee image :<input type = "file" name = "employee_image" /> 
            <br />-->

            address: <input type = "text" name = "address" />
            <br />
             Phones: <input type = "text" name = "phone1" />
            <br />
            <input type = "text" name = "phone2" />
            <br /><input type = "text" name = "phone3" />
            <br />
            
            job: <input type = "text" name = "job" />
            <br>
             start Date: <input type = "text" name = "startDate" />
            <br /> end Date: <input type = "text" name = "endDate" />
            <br /> Package Type <input type = "text" name = "packageType" />
          
           
            <input type = "submit" value = "insertEmployee" />
        </form>
        <br>
 
    </body>
</html>
