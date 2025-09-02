package com.university;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String rollNo = request.getParameter("rollNo");
        String department = request.getParameter("department");
        int year = Integer.parseInt(request.getParameter("year"));
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students (name, roll_no, department, year, email, contact) VALUES (?, ?, ?, ?, ?, ?)"
             )) {

            ps.setString(1, name);
            ps.setString(2, rollNo);
            ps.setString(3, department);
            ps.setInt(4, year);
            ps.setString(5, email);
            ps.setString(6, contact);

            ps.executeUpdate();
            // Redirect to the list page after successful insert
            response.sendRedirect("view_students.jsp");

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            throw new ServletException("Database error while adding student.", e);
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
            throw new ServletException("Unexpected error occurred.", e);
        }
    }

    // Added to avoid 405 errors if someone accesses /addStudent via GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // redirect back to the form page
        response.sendRedirect("add_student.jsp");
    }
}
