<%@ page import="java.util.ArrayList" %>
<%@ page import="project.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Students</title>
<style>
table {
    border-collapse: collapse;
    width: 80%;
    margin: auto;
}
th, td {
    text-align: left;
    padding: 8px;
}
tr:nth-child(even) {
    background-color: #f2f2f2;
}
th {
    background-color: #04AA6D;
    color: white;
}
a{
    text-decoration: none;
    color: #04AA6D;
    font-size: 20px;
    padding: 10px;
    border: 1px solid #04AA6D;
    border-radius: 10px;
    margin: 10px;
    display: inline-block;
}
a:hover{
    background-color: #04AA6D;
    color: white;
}
</style>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Fees</th>
		</tr>
		<%
			ArrayList<Student> list=(ArrayList<Student>)request.getAttribute("students");  
			for(Student s:list){
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getSemail()%></td>
			<td><%=s.getFees()%></td>
		</tr>
		<%}%>
	</table>
	<br><br><center>
	<a href="Student.html">Back to Student Modification</a>
	</center>
</body>
</html>