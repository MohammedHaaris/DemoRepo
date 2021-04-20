<%@page import="com.te.springmvc1.bean.EmployeeBean"%>
<%@page import="lombok.EqualsAndHashCode.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String msg= (String)request.getAttribute("msg"); %>
	<%EmployeeBean  bean= (EmployeeBean)request.getAttribute("data"); %>
	<%@include file= "headder.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<fieldset>
		<legend>Delete</legend>
		<form action="">
			<table>
				<tr>
					<td>enter id</td>
					<td>:</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					
					<td><input type="submit" name="Delete"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	
</body>
</html>