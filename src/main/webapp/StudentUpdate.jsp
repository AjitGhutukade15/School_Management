<%@page import="java.io.PrintWriter"%>
<%@page import="project.Student"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
        background-color: #04AA6D;
        color: white;
        padding: 10px 20px;
        border-radius: 10px;
        text-decoration: none;
        font-size: 18px;
    }

    .back-link a:hover {
        background-color: white;
        color: #04AA6D;
    }

    .form-container {
        margin-top: 20px;
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        display: inline-block;
        text-align: left;
    }

    .form-container label {
        display: block;
        margin-bottom: 5px;
        font-size: 16px;
    }

    .form-container input {
        padding: 10px;
        margin-bottom: 15px;
        font-size: 16px;
        width: 100%;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    .button-container {
        display: flex;
        justify-content: center;
        gap: 10px;
    }

    /* Styling for Update button */
    .button-container .update-button {
        padding: 10px 20px;
        font-size: 18px;
        border-radius: 10px;
        border: none;
        cursor: pointer;
        background-color: #04AA6D;
        color: white;
        min-width: 150px;
    }

    .button-container .update-button:hover {
        background-color: white;
        color: #04AA6D;
        border: 1px solid #04AA6D;
    }

    /* Styling for Back button */
    .button-container .back-button {
        padding: 10px 20px;
        font-size: 18px;
        border-radius: 10px;
        border: none;
        cursor: pointer;
        background-color: #04AA6D; /*green color for the back button */
        color: white;
        min-width: 150px;
    }

    .button-container .back-button:hover {
         background-color: white;
        color: #04AA6D;
        border: 1px solid #04AA6D;
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
    <h2>Update Student Details</h2>
    <div class="form-container">
        <form action="UpdateStudentServlet" method="post">
            <input type="hidden" name="id" value="<%= t.getId() %>">

            <label for="name">Name:</label>
            <input type="text" name="name" value="<%= t.getName() %>" required>

            <label for="email">Email:</label>
            <input type="email" name="email" value="<%= t.getSemail() %>" required>

            <label for="number">Phone Number:</label>
            <input type="text" name="number" value="<%= t.getSMoNo() %>" required>

            <label for="fees">Fees:</label>
            <input type="text" name="fees" value="<%= t.getFees() %>" required>

			<div class="button-container">
				<button type="submit" class="update-button">Update Student</button>
				<button type="submit" class="back-button" formaction="StudentUpdate.html">Back</button>
			</div>

		</form>
    </div>
    
    <% } catch (Exception e) { %>
        <p class="error-message">Error: <%= e.getMessage() %></p>
        <div class="back-link">
            <a href="StudentUpdate.html">Back to Main Menu</a>
        </div>
    <% } %>
</body>
</html>
