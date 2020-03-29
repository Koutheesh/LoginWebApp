<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<form action="StudentServlet" method="post">
	<center>
		<table>
			<tr>
				<td>Reg No :</td>
				<td><input type=text " name="regno"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type=text " name="name"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="pass2"></td>
			</tr>
			<tr>
				<td>Department :</td>
				<td><input type="dept" name="dept"></td>

			</tr>

			<tr>
				<td><input type="submit" name="submit" value="register">
				</td>
				<td><a href="index.jsp">Login Page</a></td>
			</tr>

		</table>
	</center>
</form>

<% String message = (String)request.getAttribute("alertMsg");%>
	
	<% if(message!=null){ %>
	<script type="text/javascript">
    var msg = "<%=message%>";
    alert(msg);
</script>
	
	<%} %>
	
</body>
</html>