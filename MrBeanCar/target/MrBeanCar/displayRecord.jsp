<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.abc.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Output Page</title>
</head>
<body bgcolor="grey">
	<br>
	<br>
	<br>
	<%!Car car;%>
	<%
		car = (Car) request.getAttribute("car");
	%>
	<center>
		<table border="3">
			<tr>
				<td>Cid</td>
				<td><%=car.getCid()%></td>

			</tr>
			<tr>
				<td>Company</td>
			    <td><%=car.getCompany() %></td>

			</tr>
			<tr>
				<td>Model</td>
				<td><%=car.getModel()%></td>

			</tr>
			<tr>
				<td>Dateofpurchase</td>
				<td><%=car.getDateofpurchase()%></td>

			</tr>
			<tr>
				<td>Price</td>
				<td><%=car.getPrice()%></td>

			</tr>
			<tr>
				<td>Enginecapacity</td>
				<td><%=car.getEnginecapacity()%></td>

			</tr>
			<tr>
				<td>Licenceplatenumber</td>
				<td><%=car.getLicenceplatenumber() %></td>

			</tr>
			<tr>
				<td>Seatingcapacity</td>
				<td><%=car.getSeatingcapacity()%></td>

			</tr>

		</table>
	</center>

</body>
</html>