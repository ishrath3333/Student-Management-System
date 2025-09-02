<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.university.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
</head>
<body>
    <h2>All Students</h2>
    <a href="index.jsp">Back to Dashboard</a><br><br>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Roll No</th>
            <th>Department</th>
            <th>Year</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Actions</th>
        </tr>

        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            if (students != null) {
                for (Student s : students) {
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getRollNo() %></td>
            <td><%= s.getDepartment() %></td>
            <td><%= s.getYear() %></td>
            <td><%= s.getEmail() %></td>
            <td><%= s.getContact() %></td>
            <td>
                <a href="update_student.jsp?id=<%= s.getId() %>">Edit</a> |
                <a href="deleteStudent?id=<%= s.getId() %>">Delete</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
