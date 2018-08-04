<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
  <%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page  session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body id="add" >
<ul class="style1">
<li><a href="/LMS/Logout" ><font color="white">Logout</font></a></li>
<li><a href="/LMS/Home" ><font color="white">Home</font></a></li>
 <h3 class="style1">Lab Management System</h3>
</ul>

  <h1>Lab Details</h1>

<div id="detail">
<s:form action="DeleteEntry" commandName="lb" method="post">
<fieldset>
<legend><h3 class="style2">Lab Deactivate</h3></legend>
<table class ="tabprop" border="0">

<br></br>


<c:forEach items="${search}" var="ldb">
<tr>
<td><b>Lab ID</b></td>
<td><s:input type="text" name="id" value="${ldb.labId}" path="labId"  readonly="true"></s:input></td>
</tr>
<tr>
<td><b>Lab Name</b></td>
<td><input type="text" name="type" path="type" value="${ldb.labName}" readonly="true"></input></td>
</tr>
<tr>
<td><b>Lab type</b></td>
<td>
<input type="text" name ="labtype" path="labtype" value="${ldb.type }"  readonly="true"></input>

</td>
</tr>
<tr>
<td><b>Capacity</b></td>
<td><input type="text" name="capcity"  path="capacity" value="${ldb.capacity }"  readonly="true"></input></td>
</tr>
<tr>
<td><b>Country</b></td>
<td><input type="text" list="countries" path="country" name="mycountry"  value=" ${ldb.country }"  readonly="true"/>
<datalist id="countries">
    <option value="India">India</option>
    <option value="United States">United States</option>
    <option value="United Kingdom">United Kingdom</option>
    <option value="Germany">Germany</option>
    <option value="France">France</option>
</datalist>
</td></tr>
<tr>
<td><b>City</b></td>
<td><input type="text" list="cities" name="city" path="city" value="${ldb.city }"  readonly="true" />
<datalist id="cities">
    <option value="chennai">Chennai</option>
    <option value="hyderabad">Hyderabad</option>
    <option value="pune">Pune</option>
    <option value="banglore">Bangalore</option>
   </datalist>
</td></tr>
<tr>
<td><b>Status</b></td>
<td>
<input type="text" list="availability" path="status" name="status" value="${ldb.status }"  readonly="true"/>
<datalist id="availability">
    <option value="available">Available</option>
    <option value="not available">Not Available</option>
    </datalist>
</td>
</tr>
<tr>
<td><b>Systems Availabe</b></td>
<td><input type="text" name="sysavl" value="${ldb.systemsAvailable }" path="systemsAvailable"  readonly="true"></input></td>
</tr>
<tr>
<td><b>White Board</b></td>
<td>
<input type="text" list="availability" path="whiteBoard" name="wboard" value=" ${ldb.whiteBoard }"  readonly="true"/>
<datalist id="availability">
    <option value="available">Available</option>
    <option value="not available">Not Available</option>
    </datalist>
</td>
</tr>
<tr>
<td><b>AC</b></td>
<td>
<input type="text" list="availability" name="ac" path="airConditioner" value=" ${ldb.airConditioner }"  readonly="true"/>
<datalist id="availability">
    <option value="available">Available</option>
    <option value="not available">Not Available</option>
    </datalist>
</td>
</tr>
<tr>
<td><b>Projector</b></td>
<td>
<input type="text" list="availability" name="projector" path="projector" value="${ldb.projector }" readonly="true"/>
<datalist id="availability">
    <option value="available">Available</option>
    <option value="not available">Not Available</option>
    </datalist>
</td>
</tr>
<tr>
<td><b>Phone</b></td>
<td>
<input type="text" list="availability" name="phone" path="phone" value="${ldb.phone }" readonly="true"/>
<datalist id="availability">
    <option value="available">Available</option>
    <option value="not available">Not Available</option>
    </datalist>
</td>
</tr>
<tr>
<td><b>Mike</b></td>
<td>
<input type="text" list="availability" name="mike" path="mike" value=" ${ldb.mike } " readonly="true"/>
<datalist id="availability">
    <option value="available">Available</option>
    <option value="not available">Not Available</option>
    </datalist>
</td>
</tr>
<tr>
<td><b>Sound System</b></td>
<td>
<input type="text" list="availability" name="soundsys" path="soundSystem" value="${ldb.soundSystem } " readonly="true"/>
<datalist id="availability">
    <option value="available">Available</option>
    <option value="not available">Not Available</option>
    </datalist>
</td>
</tr>
<tr>
<td><b>Video Conference</b></td>
<td>
<s:input type="text" list="availability" name="videoconf" path="videoConference" value="${ldb.videoConference }" readonly="true" />

</td>
</tr>
 </c:forEach>
</table>
<br></br>
<input type="submit" value="Deactivate" name="sear"></input>
</fieldset>
 
</s:form>
</div>
</body>
</html>
