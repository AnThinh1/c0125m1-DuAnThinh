package com.example.tuluyen;

public class Employee {
    private int id;
    private String fullname;
    private String email;
    private String phone;
    private String department;
    private double salary;        // đổi từ String -> double
    private String hiredate;      // vẫn giữ String (format yyyy-MM-dd)

    public Employee(String fullname, String email, String phone, String department, double salary, String hiredate) {
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    public Employee(int id,String fullname, String email, String phone, String department, double salary, String hiredate){
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getHireDate() {
        return hiredate;
    }
}
