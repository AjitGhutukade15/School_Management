<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View One Teacher</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>number</th>
		</tr>
		<tr>
			<td><%= request.getAttribute("id1") %></td>
			<td><%= request.getAttribute("name1") %></td> 
			<td><%= request.getAttribute("email") %></td>
			<td><%= request.getAttribute("number") %></td>
		</tr>
	</table>
	  <center>
  <br><br>
   <a href="TeacherView.html">Back to Teacher View</a>
  </center>
</body>
</html>