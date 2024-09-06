<%@ page import="java.util.ArrayList" %>
<%@ page import="project.Teacher" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Teacher</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Number</th>
		</tr>
		<%
			ArrayList<Teacher> list=(ArrayList<Teacher>)request.getAttribute("Teacher");  
			for(Teacher s:list){
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getEmail()%></td>
			<td><%=s.getNumber()%></td>
		</tr>
		<%}%>
	</table>
	<br><br><center>
	<a href="Teacher.html">Back to Teacher Modification</a>
	</center>
</body>
</html>