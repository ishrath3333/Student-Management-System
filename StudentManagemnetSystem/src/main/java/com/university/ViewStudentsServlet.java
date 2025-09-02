package com.university;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Student> students = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setRollNo(rs.getString("roll_no"));
                student.setDepartment(rs.getString("department"));
                student.setYear(rs.getInt("year"));
                student.setEmail(rs.getString("email"));
                student.setContact(rs.getString("contact"));

                students.add(student);
            }

            // Send list to JSP
            request.setAttribute("students", students);
            request.getRequestDispatcher("view_students.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Database error while fetching students.", e);
        }
    }
}
