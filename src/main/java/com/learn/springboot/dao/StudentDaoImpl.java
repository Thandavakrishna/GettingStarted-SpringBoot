package com.learn.springboot.dao;

import com.learn.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thand on 29-01-2017.
 */
@Repository
@Qualifier("fakeData")
public class StudentDaoImpl implements StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Me", "Computer Science"));
                put(2, new Student(2, "Abc", "Finance"));
                put(3, new Student(3, "Xyz", "Maths"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }


    @Override
    public void insertStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}
