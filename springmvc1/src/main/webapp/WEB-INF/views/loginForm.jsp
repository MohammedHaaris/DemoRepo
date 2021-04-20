<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("errmsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<%=msg%>
	<%
	}
	%>
	<fieldset>
		<legend>Login</legend>
		<form action="./empLogin" method="post">
			<table>
				<tr>
					<td>Employe id</td>
					<td>:</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td><input type="submit" value="login"></td>
				</tr>
			</table>
		</form>

	</fieldset>

</body>
</html>