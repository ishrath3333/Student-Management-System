<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        label { display: inline-block; width: 100px; margin-top: 10px; }
        input { margin-top: 10px; padding: 5px; width: 250px; }
        input[type="submit"] { width: auto; padding: 7px 15px; margin-top: 20px; }
        a { display: inline-block; margin-top: 20px; }
    </style>
</head>
<body>
    <h2>Update Student</h2>

    <form action="<%= request.getContextPath() %>/updateStudent" method="post">
        <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">

        <label>Name:</label>
        <input type="text" name="name" value="<%= request.getAttribute("name") %>" required><br>

        <label>Roll No:</label>
        <input type="text" name="rollNo" value="<%= request.getAttribute("rollNo") %>" required><br>

        <label>Department:</label>
        <input type="text" name="department" value="<%= request.getAttribute("department") %>" required><br>

        <label>Year:</label>
        <input type="number" name="year" value="<%= request.getAttribute("year") %>" required><br>

        <label>Email:</label>
        <input type="email" name="email" value="<%= request.getAttribute("email") %>" required><br>

        <label>Contact:</label>
        <input type="text" name="contact" value="<%= request.getAttribute("contact") %>" required><br>

        <input type="submit" value="Update Student">
    </form>

    <a href="<%= request.getContextPath() %>/view_students.jsp">Back to Students</a>
</body>
</html>
