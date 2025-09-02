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

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the student ID from request
        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            response.getWriter().println("No student ID provided for deletion!");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid student ID!");
            return;
        }

        // Delete student from database
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?")) {

            ps.setInt(1, id);
            ps.executeUpdate();

            // Redirect back to student list page after deletion
            response.sendRedirect("view_students.jsp");

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            throw new ServletException("Database error while deleting student.", e);
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
            throw new ServletException("Unexpected error occurred.", e);
        }
    }
}
