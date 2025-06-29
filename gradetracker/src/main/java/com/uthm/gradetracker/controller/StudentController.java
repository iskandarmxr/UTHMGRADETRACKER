package com.uthm.gradetracker.controller;

import com.uthm.gradetracker.model.Student;
import com.uthm.gradetracker.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("student", new Student()); // Fix
        return "add-student";
    }

    @PostMapping("/add")
    public String saveStudent(Student student) {
        studentRepo.save(student);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Student> students = studentRepo.findAll();
        students.sort(Comparator.comparingDouble(Student::getScore).reversed());

        double average = students.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0);

        model.addAttribute("students", students);
        model.addAttribute("average", average);
        return "dashboard";
    }
}