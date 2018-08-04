<%@ page errorPage="Error.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
background-image: url(css/HomeLmsImage.jpg);
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
    float: left;
}

</style>
<body>
<ul>
  <h2>Welcome to Lab Management System </h2>
  </ul>
<a href="/LMS/LoginPage"><h2>LoginPage</h2></a>

</body>
</html>