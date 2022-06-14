package org.example.dao;

import org.example.model.Student;

import java.util.List;

public interface StudentDao {

    public Student createStudent(Student student);

    public List<Student> getAllStudents();
}
