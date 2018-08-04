<%@ page errorPage="Error.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection, tv"  />
<link rel="stylesheet" href="css/style-print.css" type="text/css"  media="print" />
<title>Logout</title>
<script type="text/javascript">
window.history.forward();
function noBack()
{window.history.forward();}
</script>

</head>
<style>

body
{
height: 100%;
background-image: url(css/imageserror1.jpg);
background-size: cover;
background-repeat: no repeat;

text-align: center;
font: 1.2em Verdana, Arial, Helvetica, sans-serif;

}
ul {
    list-style-type: none;
    margin: 0;
    padding:0;
    overflow: hidden;
    background-color: pink;
    text-align: center;
}


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
 



</style>
<body>
<ul class="style1">
<li><a href="/LMS/Logout" ><font color="white">Logout</font></a></li>
<li><a href="/LMS/Home" ><font color="white">Home</font></a></li>
</ul>
<ul>

  </ul>
<h2>Request No:${sdata.bookingId} is  ${sdata.approval}</h2>

</body>
</html>