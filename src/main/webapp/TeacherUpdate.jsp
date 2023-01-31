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
<title>Update Teacher jsp</title>
</head>
<body>
	<%
	try {
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
		EntityManager em = emf.createEntityManager();
		Teacher t = em.find(Teacher.class, id1);
	%>

	<form action="updatet" method="post">
		id: <input type="text" value="<%=t.getId()%>" name="id">
		name: <input type="text" value="<%=t.getName()%>" name="name">
		email: <input type="text" value="<%=t.getEmail()%>" name="email">
		number: <input type="text" value="<%=t.getNumber()%>"name="number">
		<input type="submit">
	</form>

<%} catch (Exception e) {
	
	out.print("Error: id is not present in database " );
}%>
</body>
</html>