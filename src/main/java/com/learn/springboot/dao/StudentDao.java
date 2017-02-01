package com.learn.springboot.dao;

import com.learn.springboot.entity.Student;

import java.util.Collection;

/**
 * Created by thand on 29-01-2017.
 */
public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
