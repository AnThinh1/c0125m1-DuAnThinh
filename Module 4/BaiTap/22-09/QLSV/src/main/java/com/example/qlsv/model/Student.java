package com.example.qlsv.model;

public class Student {
    private long id;
    private String name;
    private double gpa;

    public Student() {}
    public Student(Long id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // getter + setter

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    public String getRank() {
        if (gpa >= 8) return "Giỏi";
        if (gpa >= 6.5) return "Khá";
        if (gpa >= 5) return "Trung bình";
        return "Yếu";
    }
}

