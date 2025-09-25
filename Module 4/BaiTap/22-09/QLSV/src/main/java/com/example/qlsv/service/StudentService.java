package com.example.qlsv.service;
import com.example.qlsv.DAO.StudentDAO;
import com.example.qlsv.model.Student;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    public void addStudent(Student student) {
        studentDAO.save(student);
    }
}
