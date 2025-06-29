package com.uthm.gradetracker.controller;

import com.uthm.gradetracker.model.CourseInput;
import com.uthm.gradetracker.util.GradeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TrackerController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("courseList", List.of(new CourseInput(), new CourseInput(), new CourseInput(), new CourseInput(), new CourseInput()));
        return "tracker";
    }

    @PostMapping("/calculate")
    public String calculate(
        @RequestParam double totalCredits,
        @RequestParam double currentCGPA,
        @ModelAttribute("courseList") List<CourseInput> courseList,
        Model model) {

        double semesterTotalPoints = 0.0;
        double semesterCreditHours = 0.0;

        for (CourseInput course : courseList) {
            if (course.getGrade() != null && !course.getGrade().isEmpty()) {
                double point = GradeUtil.getPoint(course.getGrade());
                semesterTotalPoints += point * course.getCreditHour();
                semesterCreditHours += course.getCreditHour();
            }
        }

        double semesterGPA = semesterCreditHours > 0 ? semesterTotalPoints / semesterCreditHours : 0;
        double newTotalCredits = totalCredits + semesterCreditHours;
        double newTotalPoints = currentCGPA * totalCredits + semesterTotalPoints;
        double newCGPA = newTotalCredits > 0 ? newTotalPoints / newTotalCredits : 0;

        String standing;
        if (newCGPA >= 3.70) {
            standing = "Dean's List (Degree/Master/PhD)";
        } else if (newCGPA >= 3.50) {
            standing = "Dean's List (Diploma)";
        } else {
            standing = "Normal Standing";
        }

        model.addAttribute("semesterGPA", semesterGPA);
        model.addAttribute("newCGPA", newCGPA);
        model.addAttribute("newTotalCredits", newTotalCredits);
        model.addAttribute("standing", standing);
        model.addAttribute("courseList", courseList);
        return "tracker";
    }
}