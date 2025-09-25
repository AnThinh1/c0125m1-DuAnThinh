package com.example.qlsv.controller;

import com.example.qlsv.model.Student;
import com.example.qlsv.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService = new StudentService();

    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/index"; // => /WEB-INF/views/students/index.jsp
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }
}
