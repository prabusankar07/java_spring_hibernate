<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page errorPage="error.jsp" session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Lab Management System</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection, tv"  />
<link rel="stylesheet" href="css/style-print.css" type="text/css"  media="print" />


<style>
li {
    float: right;
}

a:link {
    text-decoration: none;
    color: white;
}
a#req{
 color: black;
}
li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}

h3
{
text-align:center;
color:white;
font-size:20px;
}
 

</style>
</head>
<body id="add" >

<ul class="style1">
<li><a href="/LMS/Logout" ><font color="white">Logout</font></a></li>
<li><a href="/LMS/Home" ><font color="white">Home</font></a></li>
</ul>
  <h1>Update</h1>

<div id="detail">
<s:form action="ApproveReleaseRequest" name="myForm" commandName="lb" method="post">
<fieldset>
<legend><h3 class="style2">Request Update </h3></legend>
<table class ="tabprop" border="0">
<br></br>
<table  border="2">
<tr>
<th>BookingID</th>
<th>LabID</th>
<th>LabName</th>
<th>Location</th>
<th>TrainingName</th>
<th>LOName</th>
<th>StartDate</th>
<th>EndDate</th>
<th>ReleaseDate</th>
<th>Approval</th>
<th>Approve</th>
</tr>
  <c:forEach items="${search}" var="lerb">
  <tr>
     <td> ${lerb.bookingId } </td>
   <td> ${lerb.labId } </td>
   <td> ${lerb.labName} </td>
   <td> ${lerb.location } </td>
    <td> ${lerb.trainingName } </td>
    <td>${lerb.loName } </td>
   <td> ${lerb.startDate } </td>
   <td> ${lerb.endDate } </td>
   <td> ${lerb.releaseDate } </td>
    <td> ${lerb.approval } </td>
     <td><a id="req" href="/LMS/ApproveReleaseRequest?value=${lerb.bookingId} ">approve/deny</a> </td>
   </tr>
  </c:forEach>
  
</table>
<br></br>
</fieldset>
</s:form>
</div>
</body>
</html>
