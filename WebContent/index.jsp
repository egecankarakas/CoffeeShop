<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Server.Recipe" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="index2.jsp">
	<input type="text" name="name" >
	<input type="submit" name="submitButton" value="Submit Price">
	<%if(request.getParameter("submitButton")!=null){
	Recipe r = new Recipe();
	r.readFromClient(request.getParameter("name"));
	
}
%>
</form>

</body>
</html>