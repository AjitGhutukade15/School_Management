<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View One Student</title>
<style>
  table {
    border-collapse: collapse;
    width: 60%;
    margin: auto;
    text-align: center;
  }
  th, td {
    border: 1px solid black;
    padding: 8px;
  }
  th {
    background-color: #f2f2f2;
  }
  a {
    text-decoration: none;
    font-size: 20px;
    color: blue;
    padding: 10px;
    border: 1px solid blue;
    border-radius: 5px;
    margin: 10px;
    display: inline-block;
  }
  a:hover {
    background-color: blue;
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
    <tr>
      <td><%= request.getAttribute("id1") %></td>
      <td><%= request.getAttribute("name1") %></td> 
      <td><%= request.getAttribute("email") %></td>
      <td><%= request.getAttribute("Fees") %></td>
    </tr>
  </table>
  <center>
    <br><br>
    <a href="StudentView.html">Back to Student View</a>
  </center>
</body>
</html>