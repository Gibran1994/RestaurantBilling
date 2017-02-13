<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Total Bill amount is : 
<%

double total=com.rest.ser.FinalizeService.getAmt();
out.print(total);
%>

<br>

<a href='/RestaurantBilling/login.html'> Click here to go to login page </a></h1>
</body>
</html>