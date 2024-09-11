<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View One Teacher</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }

    table {
        width: 50%;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
    }

    th, td {
        padding: 15px;
        text-align: center;
        border: 1px solid #ddd;
    }

    th {
        background-color: #04AA6D;
        color: white;
    }

    td {
        background-color: #f9f9f9;
    }

    a {
        text-decoration: none;
        font-size: 18px;
        color: #04AA6D;
        padding: 10px 20px;
        border: 2px solid #04AA6D;
        border-radius: 5px;
        margin: 10px;
        display: inline-block;
        background-color: white;
    }

    a:hover {
        background-color: #04AA6D;
        color: white;
    }
</style>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Number</th>
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
