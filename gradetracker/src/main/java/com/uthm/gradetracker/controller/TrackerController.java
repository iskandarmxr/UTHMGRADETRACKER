package com.uthm.gradetracker.controller;

import com.uthm.gradetracker.model.TrackerForm;
import com.uthm.gradetracker.model.CourseInput;
import com.uthm.gradetracker.util.GradeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrackerController {

    @GetMapping("/")
    public String showForm(Model model) {
        TrackerForm form = new TrackerForm();
        for (int i = 0; i < 5; i++) {
            form.getCourseList().add(new CourseInput());
        }
        model.addAttribute("trackerForm", form);
        return "tracker";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute TrackerForm trackerForm, Model model) {
        double semesterTotalPoints = 0.0;
        double semesterCreditHours = 0.0;

        for (CourseInput course : trackerForm.getCourseList()) {
            if (course.getGrade() != null && !course.getGrade().isEmpty()) {
                double point = GradeUtil.getPoint(course.getGrade());
                semesterTotalPoints += point * course.getCreditHour();
                semesterCreditHours += course.getCreditHour();
            }
        }

        double semesterGPA = semesterCreditHours > 0 ? semesterTotalPoints / semesterCreditHours : 0;
        double newTotalCredits = trackerForm.getTotalCredits() + semesterCreditHours;
        double newTotalPoints = trackerForm.getCurrentCGPA() * trackerForm.getTotalCredits() + semesterTotalPoints;
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
        model.addAttribute("trackerForm", trackerForm);
        return "tracker";
    }
}