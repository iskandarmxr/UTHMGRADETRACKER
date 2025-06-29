package com.uthm.gradetracker.repository;

import com.uthm.gradetracker.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}