package com.university;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    // Handles GET request -> Show the update form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.getWriter().println("No student ID provided!");
            return;
        }

        int id = Integer.parseInt(idParam);

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                response.getWriter().println("No student found with ID: " + id);
                return;
            }

            // Store student details as request attributes
            request.setAttribute("id", rs.getInt("id"));
            request.setAttribute("name", rs.getString("name"));
            request.setAttribute("rollNo", rs.getString("roll_no"));
            request.setAttribute("department", rs.getString("department"));
            request.setAttribute("year", rs.getInt("year"));
            request.setAttribute("email", rs.getString("email"));
            request.setAttribute("contact", rs.getString("contact"));

            // Forward to JSP
            request.getRequestDispatcher("update_student.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }

    // Handles POST request -> Update student in DB
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String rollNo = request.getParameter("rollNo");
        String department = request.getParameter("department");
        int year = Integer.parseInt(request.getParameter("year"));
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE students SET name=?, roll_no=?, department=?, year=?, email=?, contact=? WHERE id=?")) {

            ps.setString(1, name);
            ps.setString(2, rollNo);
            ps.setString(3, department);
            ps.setInt(4, year);
            ps.setString(5, email);
            ps.setString(6, contact);
            ps.setInt(7, id);

            ps.executeUpdate();

            // Redirect to student list after update
            response.sendRedirect("view_students.jsp");

        } catch (SQLException e) {
            throw new ServletException("Database error during update: " + e.getMessage(), e);
        }
    }
}
