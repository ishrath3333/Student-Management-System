<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
</head>
<body>
    <h2>Add New Student</h2>
    
    <!-- Form submits to AddStudentServlet -->
<form action="addStudent" method="post">
            Name: <input type="text" name="name" required>
        </p>
        <p>
            Roll No: <input type="text" name="rollNo" required>
        </p>
        <p>
            Department: <input type="text" name="department" required>
        </p>
        <p>
            Year: <input type="number" name="year" min="1" max="4" required>
        </p>
        <p>
            Email: <input type="email" name="email" required>
        </p>
        <p>
            Contact: <input type="text" name="contact" required>
        </p>
        <p>
            <input type="submit" value="Add Student">
        </p>
    </form>

    <br>
    <a href="index.jsp">⬅ Back to Dashboard</a>
</body>
</html>
