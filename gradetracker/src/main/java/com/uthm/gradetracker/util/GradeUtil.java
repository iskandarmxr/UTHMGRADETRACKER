package com.uthm.gradetracker.util;

import java.util.HashMap;
import java.util.Map;

public class GradeUtil {
    private static final Map<String, Double> gradeToPoint = new HashMap<>();

    static {
        gradeToPoint.put("A+", 4.00);
        gradeToPoint.put("A", 4.00);
        gradeToPoint.put("A-", 3.70);
        gradeToPoint.put("B+", 3.30);
        gradeToPoint.put("B", 3.00);
        gradeToPoint.put("B-", 2.70);
        gradeToPoint.put("C+", 2.30);
        gradeToPoint.put("C", 2.00);
        gradeToPoint.put("C-", 1.50);
        gradeToPoint.put("D", 1.00);
        gradeToPoint.put("E", 0.00);
    }

    public static double getPoint(String grade) {
        return gradeToPoint.getOrDefault(grade.toUpperCase(), 0.0);
    }
}