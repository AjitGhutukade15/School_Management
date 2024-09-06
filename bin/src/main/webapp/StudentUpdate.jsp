<%@page import="java.io.PrintWriter"%>
<%@page import="project.Student"%>
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
		Student t = em.find(Student.class, id1);
	%>

	<form action="updateS" method="post">
		id: <input type="text" value="<%=t.getId()%>" name="id">
		name: <input type="text" value="<%=t.getName()%>" name="name">
		email: <input type="text" value="<%=t.getSemail()%>" name="email">
		number: <input type="text" value="<%=t.getSMoNo()%>"name="number">
		Fees: <input type="text" value="<%=t.getFees()%>"name="fees">
		<input type="submit">
	</form>

<%} catch (Exception e) {
	
	out.print("Error: id is not present in database " );
}%>
</body>
</html>