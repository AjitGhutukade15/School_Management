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
<title>Update Student JSP</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        padding: 20px;
        text-align: center;
    }

    .error-message {
        color: red;
        font-size: 18px;
        margin-bottom: 20px;
    }

    .back-link a {
        background-color: #007BFF;
        color: white;
        padding: 10px 20px;
        border-radius: 4px;
        text-decoration: none;
        font-size: 18px;
    }

    .back-link a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <%
    try {
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            throw new Exception("ID parameter is missing.");
        }
        int id1 = Integer.parseInt(id);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
        EntityManager em = emf.createEntityManager();
        Student t = em.find(Student.class, id1);
        if (t == null) {
            throw new Exception("Student ID not found");
        }
    %>
    <!-- This should not be reached if there is an error -->
    <p>Student details found successfully.</p>
    <% } catch (Exception e) { %>
        <p class="error-message">Error: <%= e.getMessage() %></p>
        <div class="back-link">
            <a href="StudentUpdate.html">Back to Main Menu</a>
        </div>
    <% } %>
</body>
</html>
