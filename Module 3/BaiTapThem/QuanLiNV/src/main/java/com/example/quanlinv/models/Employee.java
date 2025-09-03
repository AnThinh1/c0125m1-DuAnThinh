package com.example.quanlinv.models;

public class Employee {
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private Integer departmentId;  // cho phép null
    private String departmentName; // từ bảng departments (LEFT JOIN)

    public Employee() {}

    public Employee(String fullName, String email, String phone, Integer departmentId) {
        this.fullName = fullName; this.email = email; this.phone = phone; this.departmentId = departmentId;
    }

    public Employee(int id, String fullName, String email, String phone) {
        this.id = id; this.fullName = fullName; this.email = email; this.phone = phone;
    }

    public Employee(int id, String fullName, String email, String phone, Integer departmentId, String departmentName) {
        this.id = id; this.fullName = fullName; this.email = email; this.phone = phone;
        this.departmentId = departmentId; this.departmentName = departmentName;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Integer getDepartmentId() { return departmentId; }
    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
}
