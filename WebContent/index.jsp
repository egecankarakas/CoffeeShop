<%@page import="java.io.ObjectOutputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="Server.*,java.net.*,java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coffee Shop Simulation</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%!Shop connectToServer(Shop cafeNero) {
		Shop nero = new Shop("temp Shop");
		try {
			Socket socket = new Socket("localhost", 4444);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(cafeNero);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			nero = (Shop)ois.readObject();
			oos.close();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nero;
	}%>
	<%
		Shop cafeNero;
		if (session.getAttribute("Shop") == null) {
			cafeNero = new Shop(session.getId());
			session.setAttribute("Shop", cafeNero);
			pageContext.setAttribute("day", cafeNero.day);
			pageContext.setAttribute("balance", cafeNero.balance);
			pageContext.setAttribute("coffeeInventory",
					cafeNero.inventory.coffee);
			pageContext.setAttribute("cupsInventory",
					cafeNero.inventory.cups);
			pageContext.setAttribute("milkInventory",
					cafeNero.inventory.milk);
			pageContext.setAttribute("sugarInventory",
					cafeNero.inventory.sugar);
			pageContext.setAttribute("cupPrice",
					cafeNero.priceTable.cupPrice);
			pageContext.setAttribute("coffeePrice",
					cafeNero.priceTable.coffeePrice);
			pageContext.setAttribute("sugarPrice",
					cafeNero.priceTable.sugarPrice);
			pageContext.setAttribute("milkPrice",
					cafeNero.priceTable.milkPrice);

		} else {
			cafeNero = (Shop) session.getAttribute("Shop");
			int day = cafeNero.day;
			cafeNero.prices[day] = Double.parseDouble(request
					.getParameter("price"));
			cafeNero.inventory.coffee += Double.parseDouble(request
					.getParameter("coffeeOrder"));
			cafeNero.inventory.cups += Integer.parseInt(request
					.getParameter("cupOrder"));
			cafeNero.inventory.milk += Double.parseDouble(request
					.getParameter("milkOrder"));
			cafeNero.inventory.sugar += Double.parseDouble(request
					.getParameter("sugarOrder"));

			cafeNero.balance -= cafeNero.priceTable.cupPrice
					* Integer.parseInt(request.getParameter("cupOrder"));
			cafeNero.balance -= cafeNero.priceTable.coffeePrice
					* Double.parseDouble(request
							.getParameter("coffeeOrder"));
			cafeNero.balance -= cafeNero.priceTable.sugarPrice
					* Double.parseDouble(request.getParameter("sugarOrder"));
			cafeNero.balance -= cafeNero.priceTable.milkPrice
					* Double.parseDouble(request.getParameter("milkOrder"));

			int coffee = Integer.parseInt(request.getParameter("coffee"));
			int milk = Integer.parseInt(request.getParameter("milk"));
			int sugar = Integer.parseInt(request.getParameter("sugar"));

			Recipe recipe = new Recipe(coffee, milk, sugar);

			cafeNero.recipes[day] = recipe;

			cafeNero.balanceUpdater();
			pageContext.setAttribute("dailySales",
					cafeNero.dailySales[cafeNero.day - 1]);
			pageContext.setAttribute("day", cafeNero.day);
			pageContext.setAttribute("balance", cafeNero.balance);
			pageContext.setAttribute("coffeeInventory",
					cafeNero.inventory.coffee);
			pageContext.setAttribute("cupsInventory",
					cafeNero.inventory.cups);
			pageContext.setAttribute("milkInventory",
					cafeNero.inventory.milk);
			pageContext.setAttribute("sugarInventory",
					cafeNero.inventory.sugar);
			pageContext.setAttribute("cupPrice",
					cafeNero.priceTable.cupPrice);
			pageContext.setAttribute("coffeePrice",
					cafeNero.priceTable.coffeePrice);
			pageContext.setAttribute("sugarPrice",
					cafeNero.priceTable.sugarPrice);
			pageContext.setAttribute("milkPrice",
					cafeNero.priceTable.milkPrice);
			cafeNero = connectToServer(cafeNero);
		}
	%>


	<form action="index.jsp" method="get" id="priceform">



		<p>Coffee Shop Simulation</p>
		<table width="80%" border="1">
			<tr>
				<td colspan="2"><strong>Recipe</strong></td>
				<td colspan="4"><strong>Inventory</strong></td>
			</tr>
			<tr>
				<td><strong>Ingredient</strong></td>
				<td><strong>Usage Amount per Cup</strong></td>
				<td><strong>-</strong></td>
				<td><strong>Available Stocks</strong></td>
				<td><strong>Unit Price</strong></td>
				<td><strong>Order Amount</strong></td>
			</tr>
			<tr>
				<td width="18%" height="26">Coffee</td>
				<td width="26%"><input type="text" name="coffee" value="0"></td>
				<td width="10%">Cups</td>
				<td width="15%"><jsp:text>${cupsInventory}</jsp:text></td>
				<td width="9%"><jsp:text>${cupPrice}</jsp:text></td>
				<td><input type="text" name="cupOrder" value="0"></td>
			</tr>
			<tr>
				<td>Milk</td>
				<td><input type="text" name="milk" value="0"></td>
				<td>Coffee</td>
				<td><jsp:text>${coffeeInventory}</jsp:text></td>
				<td><jsp:text>${coffeePrice}</jsp:text></td>
				<td><input type="text" name="coffeeOrder" value="0"></td>
			</tr>
			<tr>
				<td>Sugar</td>
				<td><input type="text" name="sugar" value="0"></td>
				<td>Milk</td>
				<td><jsp:text>${milkInventory}</jsp:text></td>
				<td><jsp:text>${milkPrice}</jsp:text></td>
				<td><input type="text" name="milkOrder" value="0"></td>
			</tr>
			<tr>
				<td>Sales Price of Coffee</td>
				<td><input type="text" name="price" value="0"></td>
				<td>Sugar</td>
				<td><jsp:text>${sugarInventory}</jsp:text></td>
				<td><jsp:text>${sugarPrice}</jsp:text></td>
				<td><input type="text" name="sugarOrder" value="0"></td>
			</tr>
			<tr>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit" form="priceform"
						value="Submit">Submit</button></td>
				<td>Balance</td>
				<td colspan="3"><jsp:text>${balance}</jsp:text></td>
			</tr>
			<tr>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="6"><p>
						Day
						<jsp:text>${day}</jsp:text></td>
			</tr>
			<tr>
				<td>Daily Sales</td>
				<td colspan="5"><jsp:text>${dailySales}</jsp:text></td>
			</tr>
		</table>
	</form>

</body>
</html>