<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.abc.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Record Page</title>
</head>
<body bgcolor="grey">
	<br>
	<br>
	<%!Car car;%>
	<%
		car = (Car) request.getAttribute("car");
	%>

	<center>
		<form action="./CarController" method='post'>

			<table>
				<tr>
					<td>CID</td>
					<td><%=car.getCid()%></td>
					<td><input type="hidden" name="cid"
						value=<%=car.getCid()%>></td>
				</tr>
				<tr>
					<td>Company</td>
					<td><input type='text' name='company'
						value=<%=car.getCompany()%>></td>
				</tr>
				<tr>
					<td>Model</td>
					<td><input type="text" name='model'
						value=<%=car.getModel()%>></td>

				</tr>
				<tr>
					<td>Dateofpurchase</td>
					<td><input type="text" name='dateofpurchase'
						value=<%=car.getDateofpurchase()%>></td>

				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name='price'
						value=<%=car.getPrice()%>></td>

				</tr>
				<tr>
					<td>Enginecapacity</td>
					<td><input type="text" name='enginecapacity'
						value=<%=car.getEnginecapacity()%>></td>

				</tr>
				<tr>
					<td>Licenceplatenumber</td>
					<td><input type="text" name='licenceplatenumber'
						value=<%=car.getLicenceplatenumber()%>></td>

				</tr>
				<tr>
					<td>Seatingcapacity</td>
					<td><input type="text" name='seatingcapacity'
						value=<%=car.getSeatingcapacity()%>></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value='edit' name='action' /></td>
				</tr>

			</table>


		</form>



	</center>


</body>
</html>