package com.university;

public class Student {
    private int id;
    private String name;
    private String rollNo;
    private String department;
    private int year;
    private String email;
    private String contact;

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getRollNo() { return rollNo; }
    public String getDepartment() { return department; }
    public int getYear() { return year; }
    public String getEmail() { return email; }
    public String getContact() { return contact; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }
    public void setDepartment(String department) { this.department = department; }
    public void setYear(int year) { this.year = year; }
    public void setEmail(String email) { this.email = email; }
    public void setContact(String contact) { this.contact = contact; }
}
