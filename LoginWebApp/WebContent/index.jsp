<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FresherPro Demo</title>
</head>
<body>
	<center>

		<h3>FresherPro - DEMO</h3>
		<form action="StudentServlet" method="post">
			<table>
				<tr>
					<td>User Name :</td>
					<td><input type="text" name="regno"></td>
				</tr>

				<tr>
					<td>Password :</td>
					<td><input type="password" name="pass"></td>
				</tr>

				<tr>
					<td><input type="submit" name="submit" value="login"></td>
					<td><a href="register.jsp">Register</a> </td>
				</tr>


			</table>
		</form>
	</center>
	<% String message = (String)request.getAttribute("alertMsg");%>
	
	<% if(message!=null){ %>
	<script type="text/javascript">
    var msg = "<%=message%>";
    alert(msg);
</script>
	
	<%} %>
	
</body>
</html>