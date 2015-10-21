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
	pageContext.setAttribute("day", cafeNero.day);
	pageContext.setAttribute("balance", cafeNero.balance);
	pageContext.setAttribute("coffeeInventory", cafeNero.inventory.coffee); 
	pageContext.setAttribute("cupsInventory", cafeNero.inventory.cups); 
	pageContext.setAttribute("milkInventory", cafeNero.inventory.milk); 
	pageContext.setAttribute("sugarInventory", cafeNero.inventory.sugar);
	pageContext.setAttribute("cupPrice", cafeNero.priceTable.cupPrice);
	pageContext.setAttribute("coffeePrice", cafeNero.priceTable.coffeePrice);
	pageContext.setAttribute("sugarPrice", cafeNero.priceTable.sugarPrice);
	pageContext.setAttribute("milkPrice", cafeNero.priceTable.milkPrice);

}else{
	cafeNero = (Shop) session.getAttribute("Shop");
	int day = cafeNero.day;
	cafeNero.prices[day]= Double.parseDouble(request.getParameter("price"));
	cafeNero.balanceUpdater();
	pageContext.setAttribute("dailySales", cafeNero.dailySales[cafeNero.day-1]);
	pageContext.setAttribute("day", cafeNero.day);
	pageContext.setAttribute("balance", cafeNero.balance);
	pageContext.setAttribute("coffeeInventory", cafeNero.inventory.coffee); 
	pageContext.setAttribute("cupsInventory", cafeNero.inventory.cups); 
	pageContext.setAttribute("milkInventory", cafeNero.inventory.milk); 
	pageContext.setAttribute("sugarInventory", cafeNero.inventory.sugar);
	pageContext.setAttribute("cupPrice", cafeNero.priceTable.cupPrice);
	pageContext.setAttribute("coffeePrice", cafeNero.priceTable.coffeePrice);
	pageContext.setAttribute("sugarPrice", cafeNero.priceTable.sugarPrice);
	pageContext.setAttribute("milkPrice", cafeNero.priceTable.milkPrice);

}
%>


<form action="index.jsp" method="get" id="priceform">



<p>Coffee Shop Simulation</p>
<table width="80%" border="1">
  <tr>
    <td colspan="2"><strong>Receipe</strong></td>
    <td colspan="5"><strong>Inventory</strong></td>
  </tr>
  <tr>
    <td><strong>Ingredient</strong></td>
    <td><strong>Amount</strong></td>
    <td><strong>Item</strong></td>
    <td><strong>Amount</strong></td>
    <td><strong>Price per Unit</strong></td>
    <td><strong>Order Amount</strong></td>
    <td><strong>Order</strong></td>
  </tr>
  <tr>
    <td width="18%" height="26">Coffee </td>
    <td width="26%"><input type="range" name="coffee" min="0" max="10"></td>
    <td width="10%">Cups</td>
    <td width="15%"><jsp:text>${cupsInventory}</jsp:text></td>
    <td width="9%"><jsp:text>${cupPrice}</jsp:text></td>
    <td width="9%"><input type="text" name="cupOrder"></td>
    <td width="13%"><button type="submit" form="priceform" value="buyCup">Buy</button></td>
  </tr>
  <tr>
    <td>Milk</td>
    <td><input type="range" name="milk" min="0" max="10"></td>
    <td>Coffee</td>
    <td><jsp:text>${coffeeInventory}</jsp:text></td>
    <td><jsp:text>${coffeePrice}</jsp:text></td>
    <td><input type="text" name="coffeeOrder"></td>
    <td><button type="submit" form="priceform" value="buyCoffee">Buy</button></td>
  </tr>
  <tr>
    <td>Sugar</td>
    <td><input type="range" name="sugar" min="0" max="10"></td>
    <td>Milk</td>
    <td><jsp:text>${milkInventory}</jsp:text></td>
    <td><jsp:text>${milkPrice}</jsp:text></td>
    <td><input type="text" name="milkOrder"></td>
    <td><button type="submit" form="priceform" value="buyMilk">Buy</button></td>
  </tr>
  <tr>
    <td>Price per Cup</td>
    <td><input type="text" name="price"></td>
    <td>Sugar</td>
    <td><jsp:text>${sugarInventory}</jsp:text></td>
    <td><jsp:text>${sugarPrice}</jsp:text></td>
    <td><input type="text" name="sugarOrder"></td>
    <td><button type="submit" form="priceform" value="buySugar">Buy</button></td>
  </tr>
  <tr>
    <td colspan="7">&nbsp;</td>
    </tr>
  <tr>
    <td colspan="2"><button type="submit" form="priceform" value="Submit">Submit</button></td>
    <td>Balance</td>
    <td colspan="4"><jsp:text>${balance}</jsp:text></td>
  </tr>
  <tr>
    <td colspan="7">&nbsp;</td>
    </tr>
  <tr>
    <td colspan="7"><p>Day <jsp:text>${day}</jsp:text></td>
  </tr>
  <tr>
    <td>Daily Sales</td>
    <td colspan="6"> <jsp:text>${dailySales}</jsp:text></td>
  </tr>
</table>
</form>

</body>
</html>