<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Server.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coffee Shop Simulation</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
Shop cafeNero;
if(session.getAttribute("Shop") == null) {
	cafeNero = new Shop(session.getId());
	session.setAttribute("Shop", cafeNero);
}else{
	cafeNero = (Shop) session.getAttribute("Shop");
	int day = cafeNero.day;
	cafeNero.prices[day]= Double.parseDouble(request.getParameter("price"));
	cafeNero.balanceUpdater();
}
%>

<p> Welcome to Coffee Shop Simulation. </p>

This is your Coffee Shop.
You can determine the price per cup of coffee.

<p>Your current balance: <% out.println(cafeNero.balance); %></p>
<p>Today is day <% out.println(cafeNero.day); %></p>
<p>Today's sale: <% out.println(cafeNero.dailySales[cafeNero.day]); %> </p>
<form action="index.jsp" method="get" id="priceform">
  Price: 
  <input type="text" name="price">
    <button type="submit" form="priceform" value="Submit">Submit</button>

</form>

</body>
</html>