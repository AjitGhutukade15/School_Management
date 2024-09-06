<%@page import="java.io.PrintWriter"%>
<%@page import="project.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Teacher JSP</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f7f7f7; padding: 20px;">

	<%
	try {
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
		EntityManager em = emf.createEntityManager();
		Teacher t = em.find(Teacher.class, id1);
		
		if (t == null) {
			throw new Exception("Teacher ID not found");
		}
	%>

	<form action="updatet" method="post" style="background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); max-width: 400px; margin: auto;">
		<label for="id" style="font-weight: bold;">ID:</label>
		<input type="text" value="<%=t.getId()%>" name="id" style="width: 100%; padding: 10px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;">

		<label for="name" style="font-weight: bold;">Name:</label>
		<input type="text" value="<%=t.getName()%>" name="name" style="width: 100%; padding: 10px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;">

		<label for="email" style="font-weight: bold;">Email:</label>
		<input type="text" value="<%=t.getEmail()%>" name="email" style="width: 100%; padding: 10px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;">

		<label for="number" style="font-weight: bold;">Number:</label>
		<input type="text" value="<%=t.getNumber()%>" name="number" style="width: 100%; padding: 10px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;">

		<input type="submit" value="Update" style="background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; width: 100%;">
	</form>

	<% } catch (Exception e) { %>
		<p style="color: red; text-align: center;">Error: ID is not present in the database.</p>
		<div style="text-align: center;">
			<a href="TeacherUpdate.html" style="background-color: #007BFF; color: white; padding: 10px 20px; border-radius: 4px; text-decoration: none; display: inline-block; margin-top: 10px;">Back to Main Menu</a>
		</div>
	<% } %>

	<!-- Add hover effect -->
	<style>
		input[type="submit"]:hover {
			background-color: #45a049;
		}

		a:hover {
			background-color: #0056b3;
		}
	</style>

</body>
</html>
