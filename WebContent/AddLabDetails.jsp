<%@ page errorPage="error.jsp" session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
    <%@page import="java.util.List"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Lab Management System</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css"media="screen, projection, tv" />
<link rel="stylesheet" href="css/style-print.css" type="text/css" media="print"  />

<script type="text/javascript">
window.history.forward();
function noBack()
{window.history.forward();}
</script>
 
<style>
li {
    float: right;
}

a:link {
    text-decoration: none;
    color: white;
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
 h1{
 text-align:center;
 
 }
h3.style1
{
text-align:center;
color:white;
font-size:20px;
}
h3.style2
{
text-align:center;
color:black;
font-size:20px;
}
 
</style>

</head>
<body>
<ul class="style1">
<li><a href="/LMS/Logout" ><font color="white">Logout</font></a></li>
<li><a href="/LMS/Home" ><font color="white">Home</font></a></li>
 <h3 class="style1">Lab Management System</h3>
 </ul>
 <div id="wrapper">

 <body id="add" >

 <h1>Lab Details</h1>

<div id="detail">
<c:if test="${not empty errmsg}">
  Lab insertion failed...try again later!
  </c:if>
  <c:if test="${not empty success}">
  Lab inserted successfully
    </c:if>
   
<s:form action="AddLab" commandName="sb" method="post">
<fieldset>

<legend><h3 class="style2">Add Lab Details</h3></legend>
<table class ="tabprop" border="0">
<br></br>
<tr>
<td><b>Lab ID</b></td>
<td><s:input path="labId" pattern="msat[A-Za-z]{4}[A-Za-z]{4}[0-9]{4}" title="Format:msat<<city>><<loc>>9999" /></td>
</tr>
<tr>
<td><b>Lab Name</b></td>
<td><s:input path="labName"  ></s:input></td>
</tr>
<tr>
<td><b>Lab type</b></td>
<td><s:select type="text" path="type" value="${ldb.type}">
<s:option value ="Normal">Normal</s:option>
<s:option value ="Auditorium">Auditorium</s:option></s:select></td>
</tr>
<tr>
<td><b>Capacity</b></td>
<td><s:input path="capacity" type="number" min="30" ></s:input></td>
</tr>
<tr>
<td><b>Country</b></td>
<td><s:select type="text" path="country" value="${ldb.country}">
<datalist id="countries">
    <s:option value="India">India</s:option>
    <s:option value="United States">United States</s:option>
    <s:option value="United Kingdom">United Kingdom</s:option>
    <s:option value="Germany">Germany</s:option>
    <s:option value="France">France</s:option></s:select></td>
</datalist>
</tr>
<tr>
<td><b>City</b></td>
<td><s:select type="text" path="city" list="cities" value="${ldb.city}" >
<datalist id="cities">
    <s:option value="Chennai">Chennai</s:option>
    <s:option value="Hyderabad">Hyderabad</s:option>
    <s:option value="Pune">Pune</s:option>
    <s:option value="Banglore">Bangalore</s:option>
    <s:option value="Clinton">Clinton</s:option>
    <s:option value="Springfield">Springfield</s:option>
    <s:option value="London">London</s:option>
    <s:option value="Paris">Paris</s:option></s:select></td>
   </datalist>
</tr>
<tr>
<td><b>Status</b></td>
<td>
<s:select type="text"  path="status" name="status" value="${ldb.status}" >
<datalist id="availability">
    <s:option value="available">Available</s:option>
    <s:option value="not available">Not Available</s:option>
     <s:option value="deactivate">Deactivate</s:option>
    </datalist>
    </s:select>
</td>
</tr>
<tr>
<td><b>Systems Availabe</b></td>
<td><s:input path="systemsAvailable" ></s:input></td>
</tr>
<tr>
<td><b>White Board</b></td>
<td>
<s:select path="whiteBoard" list="availabilit"  pattern="available"  title="White board is mandatory" value="${ldb.whiteBoard}" >
<datalist id="availabilit">
    <s:option value="available">Available</s:option>
    <s:option value="not available">Not Available</s:option>
    </datalist>
    </s:select>
</td>
</tr>
<tr>
<td><b>AC</b></td>
<td>
<s:select path="airConditioner"  list="availabilit"  pattern="available"  title="AC is mandatory" value="${ldb.airConditioner}">
<datalist id="availabilit">
    <s:option value="available">Available</s:option>
    <s:option value="not available">Not Available</s:option>
</datalist>
</s:select>
</td>
</tr>
<tr>
<td><b>Projector</b></td>
<td>
<s:select path="projector" list="availabilit" value="${ldb.projector}" >
<datalist id="availabilit">
    <s:option value="available">Available</s:option>
    <s:option value="not available">Not Available</s:option>
    </datalist>
    </s:select>
</td>
</tr>
<tr>
<td><b>Phone</b></td>
<td>
<s:select type="text" path="phone" list="availabilit" value="${ldb.projector}" >
<datalist id="availabilit">
    <s:option value="available">Available</s:option>
    <s:option value="not available">Not Available</s:option>
    </datalist>
    </s:select>
</td>
</tr>
<tr>
<td><b>Mike</b></td>
<td>
<s:select type="text" path="mike"  value="${ldb.mike}" >
    <s:option value="available">Available</s:option>
    <s:option value="not available">Not Available</s:option>
       </s:select>
</td>
</tr>
<tr>
<td><b>Sound System</b></td>
<td>
<s:select type="text" path="soundSystem" list="availabilit" value="${ldb.soundSystem}" >

    <s:option value="available">Available</s:option>
    <s:option value="not available">Not Available</s:option>
    
    </s:select>
</td>
</tr>
<tr>
<td><b>Video Conference</b></td>
<td>
<s:select path="videoConference" list="availabilit" value="${ldb.videoConference}" >
<datalist id="availabilit">
    <s:option value="available">Available</s:option>
    <s:option value="not available">Not Available</s:option>
    </datalist>
    </s:select>
</td>
</tr>
</table>
<br></br>
<center>
<input type="submit" value="ADD"></input>
<input type="reset" value="Reset"></input>
</center>
</fieldset>
</s:form>
</div>
</body>
</html>
