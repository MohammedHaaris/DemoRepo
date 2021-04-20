<%@page import="com.te.springmvc1.bean.EmployeeBean"%>
<%@page import="lombok.EqualsAndHashCode.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<%
EmployeeBean bean = (EmployeeBean) request.getAttribute("data");
%>
<%@include file="headder.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Employee Search</legend>
		<form action="./searchForm">
			<table>
				<tr>
					<td>Search by id</td>
					<td>:</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>

					<td><input type="submit" name="Search"></td>
				</tr>
			</table>
		</form>
		<%if(bean!=null){ %>
		<h4> Name:<%=bean.getName() %></h4>
		<h4> id:<%=bean.getId() %></h4>
		<h4> Name:<%=bean.getDob() %></h4>
		<h4></h4>
		<%} %>
	</fieldset>

</body>
</html>