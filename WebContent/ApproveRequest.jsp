<%@ page errorPage="error.jsp" session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Lab Management System</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection, tv"  />
<link rel="stylesheet" href="css/style-print.css" type="text/css"  media="print" />
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



</style>
</head>
<body id="add" >
<script type="text/javascript">
function myFun()
{
	document.getElementById("bookid").value= Math.floor((Math.random() * 1000)+1);
}
</script>
<ul class="style1">
<li><a href="/LMS/Logout" ><font color="white">Logout</font></a></li>
<li><a href="/LMS/Home" ><font color="white">Home</font></a></li>
 <h3 class="style1">Lab Management System</h3>
</ul>

  <h1>Lab Request</h1>

<div id="detail">
<c:if test="${not empty errmsg}">
  Lab Not Found
  </c:if>
<s:form action="LabRequestEntryApprove" commandName="lb" method="post">
<fieldset>
<legend><h3 class="style2">Lab Request</h3></legend>
<c:forEach items="${search}" var="ldb">
<table class ="tabprop" border="0">
<br></br>
<tr>
<td><b>Booking ID</b></td>
<td><s:input type="text" name="bookingID" id="bookid" path="bookingId" readonly="true"></s:input></td>
</tr>
<tr>
<td><b>Lab ID</b></td>
<td><s:input type="text" name="labID" value="${ldb.labId}" path="labId" readonly="true"></s:input></td>
</tr>
<tr>
<td><b>Location</b></td>
<td><s:input type="text" list="cities" name="city" value="${ldb.location}" path="location"  readonly="true"/>

</td></tr>

<tr>
<td><b>Lab Name</b></td>
<td><s:input type="text" name="type" value="${ldb.labName}" path="labName" readonly="true"></s:input></td>
</tr>
<tr>
<td><b>Training Name</b></td>
<td><s:input type="text" name="training" value="${ldb.trainingName}" path="trainingName" readonly="true"></s:input></td>
</tr>
<tr>
<td><b>LO Name</b></td>
<td><s:input type="text" name="loName" path="loName" value="${ldb.loName}" readonly="true"></s:input></td>
</tr>
<tr>
<td><b>Start Date</b></td>
<td><s:input path="startDate" value="${ldb.startDate}" readonly="true"></s:input></td>
</tr>
<tr>
<td><b>End Date</b></td>
<td><s:input name="edate" path="endDate" value="${ldb.endDate}" readonly="true"></s:input></td>
</tr>
<tr>
<td><b>Approval</b></td>
<td><s:select type="text" path="approval" value="${ldb.approval}">
<s:option value = "approved">approve</s:option>
<s:option value = "denied">deny</s:option></s:select></td>
</tr>
<tr>
<td><b></b></td>
<td></td>
</tr>
</table>
</c:forEach>
<br></br>
<input type="submit" value="submit"></input>
<input type="reset" value="Reset"></input>
</fieldset>
</s:form>
</div>
</body>
</html>
